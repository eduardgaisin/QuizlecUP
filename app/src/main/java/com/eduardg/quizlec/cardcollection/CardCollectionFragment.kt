package com.eduardg.quizlec.cardcollection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.R
import com.eduardg.quizlec.database.card.CardDatabase
import com.eduardg.quizlec.databinding.CardCollectionFragmentBinding
import com.google.android.material.transition.MaterialContainerTransform

class CardCollectionFragment : Fragment() {

    private lateinit var viewModel: CardCollectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: CardCollectionFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.card_collection_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val args = CardCollectionFragmentArgs.fromBundle(requireArguments())

        val dataSource = CardDatabase.getInstance(application).cardDatabaseDao

        val viewModelFactory = CardCollectionViewModelFactory(dataSource, application, args.cardCollectionId)

        val cardCollectionViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(CardCollectionViewModel::class.java)

//        cardCollectionViewModel.collectionId = args.cardCollectionId

        val adapter = CardAdapter(parentFragmentManager, cardCollectionViewModel)
        binding.cardCollectionRecyclerView.adapter = adapter

        cardCollectionViewModel.allCards.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })

        binding.cardCollectionViewModel = cardCollectionViewModel

        binding.setLifecycleOwner(this)



        binding.addCardFloatingButton.setOnClickListener {
            AddCardDialog(cardCollectionViewModel).show(parentFragmentManager , "AddCardDialog")
//            cardCollectionViewModel.addCard(binding.frontTextEditText.text.toString(), binding.backTextEditText.text.toString())
//            binding.frontTextEditText.text.clear()
//            binding.backTextEditText.text.clear()
        }

        return binding.root
    }


}