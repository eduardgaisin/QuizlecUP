package com.eduardg.quizlec.training.choosecardcollection

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollectionlist.CardCollectionAdapter
import com.eduardg.quizlec.cardcollectionlist.CardCollectionListViewModel
import com.eduardg.quizlec.cardcollectionlist.CardCollectionListViewModelFactory
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabase
import com.eduardg.quizlec.databinding.ChooseCardCollectionFragmentBinding
import com.eduardg.quizlec.databinding.ChooseWordTrainingFragmentBinding

class ChooseCardCollectionFragment : Fragment() {

    private lateinit var chooseCardCollectionViewModel: ChooseCardCollectionViewModel
    private lateinit var binding: ChooseCardCollectionFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil
                .inflate(inflater, R.layout.choose_card_collection_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = CardCollectionDatabase.getInstance(application).cardCollectionDatabaseDao
        val viewModelFactory = ChooseCardCollectionViewModelFactory(dataSource, application)
        chooseCardCollectionViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(ChooseCardCollectionViewModel::class.java)

        val adapter = ChooseCardCollectionAdapter(parentFragmentManager)
        binding.chooseCardCollectionRecyclerView.adapter = adapter
//        adapter.outViewModel = chooseCardCollectionViewModel


        chooseCardCollectionViewModel.allCardCollections.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })

        binding.chooseCardCollectionViewModel = chooseCardCollectionViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}
