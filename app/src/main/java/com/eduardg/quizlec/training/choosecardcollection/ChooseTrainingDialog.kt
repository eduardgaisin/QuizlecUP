package com.eduardg.quizlec.training.choosecardcollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.eduardg.quizlec.R
import com.eduardg.quizlec.databinding.ChooseTrainingModalLayoutBinding
import com.eduardg.quizlec.databinding.ChooseWordTrainingFragmentBinding

//Dialog "Choose training"
class ChooseTrainingDialog(val cardCollectionId: Long): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.linear_layout_border);
        val binding: ChooseTrainingModalLayoutBinding = DataBindingUtil
                .inflate(inflater, R.layout.choose_training_modal_layout, container, false)
        binding.chooseWordLinearLayout.setOnClickListener {
            findNavController().navigate(ChooseCardCollectionFragmentDirections
                    .actionChooseCardCollectionFragmentToChooseWordTrainingFragment(cardCollectionId))
            dismiss()
        }
        binding.writeWordLinearLayout.setOnClickListener {
            findNavController().navigate(ChooseCardCollectionFragmentDirections
                    .actionChooseCardCollectionFragmentToWriteWordTrainingFragment(cardCollectionId))
            dismiss()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}