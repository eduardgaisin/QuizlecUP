package com.eduardg.quizlec.training.writeword

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eduardg.quizlec.R

class WriteWordTrainingFragment : Fragment() {

    companion object {
        fun newInstance() = WriteWordTrainingFragment()
    }

    private lateinit var viewModel: WriteWordTrainingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.write_word_training_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WriteWordTrainingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}