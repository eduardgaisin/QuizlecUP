package com.eduardg.quizlec.cardcollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.eduardg.quizlec.R
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.databinding.AddCardModalLayoutBinding
import com.eduardg.quizlec.databinding.ChooseTrainingModalLayoutBinding

// dismiss() to hide dialog

class AddCardDialog(val viewModel: CardCollectionViewModel): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.linear_layout_border);
        val binding: AddCardModalLayoutBinding = DataBindingUtil
                .inflate(inflater, R.layout.add_card_modal_layout, container, false)

        binding.confirmAddCardButton.setOnClickListener {
            viewModel.addCard(binding.termAddCardText.text.toString(),
                        binding.definitionAddCardText.text.toString())
            dismiss()
        }

        binding.cancelAddCardButton.setOnClickListener {
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