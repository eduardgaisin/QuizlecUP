package com.eduardg.quizlec.cardcollectionlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollection.CardCollectionViewModel
import com.eduardg.quizlec.databinding.AddCardCollectionModalLayoutBinding
import com.eduardg.quizlec.databinding.AddCardModalLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// dismiss() to hide dialog

class AddCardCollectionDialog(val viewModel: CardCollectionListViewModel): BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        getDialog()!!.getWindow()?.setBackgroundDrawableResource()
        val binding: AddCardCollectionModalLayoutBinding = DataBindingUtil
                .inflate(inflater, R.layout.add_card_collection_modal_layout, container, false)

        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.addButton.setOnClickListener{
            viewModel.addCardCollection(binding.cardCollectionNameEdit.text.toString(),
                    binding.cardCollectionDescriptionEdit.text.toString())
            dismiss()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 1).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

}