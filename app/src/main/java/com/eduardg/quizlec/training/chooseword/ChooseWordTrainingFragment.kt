package com.eduardg.quizlec.training.chooseword

import android.graphics.drawable.TransitionDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollection.CardCollectionFragmentArgs
import com.eduardg.quizlec.cardcollection.CardCollectionViewModel
import com.eduardg.quizlec.cardcollection.CardCollectionViewModelFactory
import com.eduardg.quizlec.database.card.CardDatabase
import com.eduardg.quizlec.databinding.ChooseWordTrainingFragmentBinding
import kotlinx.coroutines.delay

class ChooseWordTrainingFragment : Fragment() {

    private lateinit var chooseWordTrainingViewModel: ChooseWordTrainingViewModel
    private lateinit var binding: ChooseWordTrainingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil
                .inflate(inflater ,R.layout.choose_word_training_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val args = CardCollectionFragmentArgs.fromBundle(requireArguments())
        val dataSource = CardDatabase.getInstance(application).cardDatabaseDao
        val viewModelFactory = ChooseWordTrainingViewModelFactory(dataSource, application, args.cardCollectionId)
        chooseWordTrainingViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(ChooseWordTrainingViewModel::class.java)
        binding.setLifecycleOwner(this)
        
        chooseWordTrainingViewModel.allCards.observe(viewLifecycleOwner, Observer {

        })
        chooseWordTrainingViewModel.questionTerm.observe(viewLifecycleOwner, Observer {
            binding.questionTermText.text = chooseWordTrainingViewModel.questionTerm.value
        })
        chooseWordTrainingViewModel.firstAnswer.observe(viewLifecycleOwner, Observer {
            binding.firstAnswer.text = chooseWordTrainingViewModel.firstAnswer.value
        })
        chooseWordTrainingViewModel.secondAnswer.observe(viewLifecycleOwner, Observer {
            binding.secondAnswer.text = chooseWordTrainingViewModel.secondAnswer.value
        })
        chooseWordTrainingViewModel.thirdAnswer.observe(viewLifecycleOwner, Observer {
            binding.thirdAnswer.text = chooseWordTrainingViewModel.thirdAnswer.value
        })
        chooseWordTrainingViewModel.fourthAnswer.observe(viewLifecycleOwner, Observer {
            binding.fourthAnswer.text = chooseWordTrainingViewModel.fourthAnswer.value
        })

        chooseWordTrainingViewModel.nextQuestion()

        binding.firstAnswer.setOnClickListener{
            checkAnswer(0)
        }
        binding.secondAnswer.setOnClickListener{
            checkAnswer(1)
        }
        binding.thirdAnswer.setOnClickListener{
            checkAnswer(2)
        }
        binding.fourthAnswer.setOnClickListener{
            checkAnswer(3)
        }


        return binding.root
    }

    private fun checkAnswer(userAnswer: Int){
//        chooseWordTrainingViewModel.answer(userAnswer)
        var isRight: Boolean = chooseWordTrainingViewModel.answer(userAnswer) ?: false
        if(isRight){
            Toast.makeText(activity, "Right", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(activity, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

}