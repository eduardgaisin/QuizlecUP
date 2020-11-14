package com.eduardg.quizlec.training.choosetraining

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.eduardg.quizlec.R
import com.eduardg.quizlec.databinding.ChooseTrainingFragmentBinding
import com.eduardg.quizlec.training.ChooseTrainingFragmentArgs
import com.eduardg.quizlec.training.ChooseTrainingFragmentDirections

class ChooseTrainingFragment : Fragment() {

    private lateinit var viewModel: ChooseTrainingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: ChooseTrainingFragmentBinding = DataBindingUtil
            .inflate(inflater, R.layout.choose_training_fragment, container, false)

        var args = ChooseTrainingFragmentArgs.fromBundle(requireArguments())

        binding.writeWordLinearLayout.setOnClickListener {
            findNavController().navigate(ChooseTrainingFragmentDirections.actionChooseTrainingFragmentToWriteWordTrainingFragment(args.cardCollectionId))
        }
        binding.chooseWordLinearLayout.setOnClickListener {
            findNavController().navigate(ChooseTrainingFragmentDirections.actionChooseTrainingFragmentToChooseWordTrainingFragment(args.cardCollectionId))
        }

        return binding.root
    }
}