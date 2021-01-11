package com.eduardg.quizlec.testscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollection.CardCollectionFragmentArgs
import com.eduardg.quizlec.database.card.CardDatabase
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabase
import com.eduardg.quizlec.databinding.TestScreenFragmentBinding
import com.eduardg.quizlec.databinding.TestScreenSelectCollectionFragmentBinding

class TestScreen : Fragment() {

    private lateinit var binding: TestScreenFragmentBinding

    private lateinit var viewModel: TestScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.test_screen_fragment, container, false)
        val args = CardCollectionFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = CardDatabase.getInstance(application).cardDatabaseDao
        val viewModelFactory = TestScreenViewModelFactory(dataSource, application, args.cardCollectionId)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TestScreenViewModel::class.java)

        binding.lifecycleOwner = this

        return binding.root
    }

}