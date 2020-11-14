package com.eduardg.quizlec.training.chooseword

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
import com.eduardg.quizlec.cardcollection.CardCollectionViewModel
import com.eduardg.quizlec.cardcollection.CardCollectionViewModelFactory
import com.eduardg.quizlec.database.card.CardDatabase
import com.eduardg.quizlec.databinding.ChooseWordTrainingFragmentBinding

class ChooseWordTrainingFragment : Fragment() {

    private lateinit var viewModel: ChooseWordTrainingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding: ChooseWordTrainingFragmentBinding = DataBindingUtil
                .inflate(inflater ,R.layout.choose_word_training_fragment, container, false)

        val args = CardCollectionFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = CardDatabase.getInstance(application).cardDatabaseDao
        val viewModelFactory = ChooseWordTrainingViewModelFactory(dataSource, application, args.cardCollectionId)
        val chooseWordTrainingViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(ChooseWordTrainingViewModel::class.java)

        return binding.root
    }


}