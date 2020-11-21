package com.eduardg.quizlec.training.writeword

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
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
import com.eduardg.quizlec.database.card.CardDatabase
import com.eduardg.quizlec.databinding.WriteWordTrainingFragmentBinding
import com.eduardg.quizlec.training.chooseword.ChooseWordTrainingViewModel
import com.eduardg.quizlec.training.chooseword.ChooseWordTrainingViewModelFactory

class WriteWordTrainingFragment : Fragment() {

    private lateinit var writeWordTrainingViewModel: WriteWordTrainingViewModel
    private lateinit var binding: WriteWordTrainingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.write_word_training_fragment, container, false)
        val application = requireNotNull(this.activity).application

        val args = CardCollectionFragmentArgs.fromBundle(requireArguments())
        val dataSource = CardDatabase.getInstance(application).cardDatabaseDao
        val viewModelFactory = WriteWordTrainingViewModelFactory(dataSource, application, args.cardCollectionId)
        writeWordTrainingViewModel =
                ViewModelProviders.of(this, viewModelFactory).get(WriteWordTrainingViewModel::class.java)
        binding.setLifecycleOwner(this)

        writeWordTrainingViewModel.allCards.observe(viewLifecycleOwner, Observer {  })

        writeWordTrainingViewModel.questionTerm.observe(viewLifecycleOwner, Observer {
            binding.questionTerm.text = writeWordTrainingViewModel.questionTerm.value
        })

        binding.sendAnswer.setOnClickListener {
            checkAnswer(binding.answerEditText.text.toString())
            binding.answerEditText.text.clear()
        }

        return binding.root
    }

    private fun checkAnswer(userAnswer: String){
        var isRight = writeWordTrainingViewModel.checkAnswer(userAnswer)
        if(isRight){
            Toast.makeText(activity, "Right", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(activity, "Wrong", Toast.LENGTH_SHORT).show()
        }
    }

}