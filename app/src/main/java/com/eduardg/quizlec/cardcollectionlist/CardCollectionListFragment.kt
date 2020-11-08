package com.eduardg.quizlec.cardcollectionlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollection.CardAdapter
import com.eduardg.quizlec.cardcollection.CardCollectionViewModel
import com.eduardg.quizlec.cardcollection.CardCollectionViewModelFactory
import com.eduardg.quizlec.database.card.CardDatabase
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabase
import com.eduardg.quizlec.databinding.CardCollectionFragmentBinding
import com.eduardg.quizlec.databinding.CardCollectionListFragmentBinding

class CardCollectionListFragment : Fragment() {

    private lateinit var viewModel: CardCollectionListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var binding: CardCollectionListFragmentBinding = DataBindingUtil
                .inflate(inflater, R.layout.card_collection_list_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = CardCollectionDatabase.getInstance(application).cardCollectionDatabaseDao

        val viewModelFactory = CardCollectionListViewModelFactory(dataSource, application)

        val cardCollectionListViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(CardCollectionListViewModel::class.java)


        val adapter = CardCollectionAdapter()
        binding.cardCollectionListRecyclerView.adapter = adapter


        cardCollectionListViewModel.allCardCollections.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })


        binding.cardCollectionListViewModel = cardCollectionListViewModel
        binding.setLifecycleOwner(this)


        binding.addCardCollectionButton.setOnClickListener {
            cardCollectionListViewModel.addCardCollection(binding.collectionNameTextEdit.text.toString(),
                    binding.collectionDescriptionTextEdit.text.toString())
        }



        return binding.root
    }

}