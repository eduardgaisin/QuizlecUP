package com.eduardg.quizlec.testscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eduardg.quizlec.R
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabase
import com.eduardg.quizlec.databinding.TestScreenSelectCollectionFragmentBinding
import java.lang.reflect.Array.get

class TestScreenSelectCollectionFragment : Fragment() {

    private lateinit var binding: TestScreenSelectCollectionFragmentBinding

    private lateinit var viewModel: TestScreenSelectCollectionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.test_screen_select_collection_fragment, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = CardCollectionDatabase.getInstance(application).cardCollectionDatabaseDao
        val viewModelFactory = TestScreenSelectCollectionViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TestScreenSelectCollectionViewModel::class.java)

        val adapter = TestScreenSelectCollectionAdapter(parentFragmentManager)
        binding.chooseCardCollectionRecyclerView.adapter = adapter

        viewModel.allCardCollections.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })
        binding.lifecycleOwner = this

        return binding.root
    }

}