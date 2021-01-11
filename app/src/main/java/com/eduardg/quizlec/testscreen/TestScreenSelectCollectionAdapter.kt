package com.eduardg.quizlec.testscreen

import com.eduardg.quizlec.databinding.TestScreenCardCollectionItemBinding
import com.eduardg.quizlec.training.choosecardcollection.ChooseCardCollectionFragmentDirections

import android.app.ProgressDialog.show
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.R
import com.eduardg.quizlec.cardcollectionlist.CardCollectionAdapter
import com.eduardg.quizlec.cardcollectionlist.CardCollectionListFragmentDirections
import com.eduardg.quizlec.cardcollectionlist.CardCollectionListViewModel
import com.eduardg.quizlec.database.cardcollection.CardCollection
import com.eduardg.quizlec.databinding.CardCollectionItemBinding
import com.eduardg.quizlec.databinding.SelectCardCollectionItemBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.withContext

class TestScreenSelectCollectionAdapter(val fragmentManager: FragmentManager):
    RecyclerView.Adapter<TestScreenSelectCollectionAdapter.ViewHolder>() {

    var data = listOf<CardCollection>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TestScreenCardCollectionItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.cardCollectionName.text = item.name
        holder.cardCollectionDescription.text = item.description
//        holder.clickableLayout.setOnClickListener {view ->
//            view.findNavController().navigate(ChooseCardCollectionFragmentDirections.actionChooseCardCollectionFragmentToChooseTrainingFragment(item.cardCollectionId))
//        }
        holder.toTestButton.setOnClickListener {view ->
//            view.findNavController().navigate()
        }
        holder.card.setOnClickListener {view ->
            TransitionManager.beginDelayedTransition(holder.card, AutoTransition())
            holder.binding.cardCollectionDescriptionLinearLayout.isGone =
                !holder.binding.cardCollectionDescriptionLinearLayout.isGone
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(val binding: TestScreenCardCollectionItemBinding): RecyclerView.ViewHolder(binding.root){
        var cardCollectionName = binding.cardCollectionNameText
        var cardCollectionDescription = binding.cardCollectionDescriptionText
        var toTestButton = binding.toTestButton
        var card = binding.card
    }
}