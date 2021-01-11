package com.eduardg.quizlec.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollection.CardCollectionFragmentArgs
import com.eduardg.quizlec.databinding.FragmentTrainingResultBinding

class TrainingResultFragment : Fragment() {

    private lateinit var binding: FragmentTrainingResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training_result, container, false)
        val args = TrainingResultFragmentArgs.fromBundle(requireArguments())

        binding.resultText.text = args.rightAnswer.toString() + "/" + args.allQuestions.toString()
        binding.goBackButton.setOnClickListener {
            findNavController().navigate(R.id.chooseCardCollectionFragment)
        }

        return binding.root
    }
}