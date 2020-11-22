package com.eduardg.quizlec.cardcollection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.eduardg.quizlec.R
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.databinding.ChooseTrainingModalLayoutBinding
import com.eduardg.quizlec.databinding.EditCardModalLayoutBinding
import com.eduardg.quizlec.training.choosecardcollection.ChooseCardCollectionFragmentDirections

// dismiss() to hide dialog

class EditCardDialog(var card: Card, val viewModel: CardCollectionViewModel): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getDialog()!!.getWindow()?.setBackgroundDrawableResource(R.drawable.linear_layout_border);
        val binding: EditCardModalLayoutBinding = DataBindingUtil
                .inflate(inflater, R.layout.edit_card_modal_layout, container, false)

        binding.termEditCardText.setText(card.term)
        binding.definitionEditCardText.setText(card.definition)

        binding.cancelEditCardButton.setOnClickListener {
            dismiss()
        }

        binding.confirmEditCardButton.setOnClickListener {
            viewModel.updateCard(Card(card.cardId, binding.termEditCardText.text.toString(),
                                binding.definitionEditCardText.text.toString(), card.collectionId))
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