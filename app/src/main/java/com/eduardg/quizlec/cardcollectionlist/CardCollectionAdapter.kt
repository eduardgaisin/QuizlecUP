package com.eduardg.quizlec.cardcollectionlist

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.database.cardcollection.CardCollection
import com.eduardg.quizlec.databinding.CardCollectionItemBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CardCollectionAdapter(): RecyclerView.Adapter<CardCollectionAdapter.ViewHolder>(){

    var outViewModel: CardCollectionListViewModel? = null

    var data = listOf<CardCollection>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardCollectionItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardCollectionAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.cardCollectionName.text = item.name
        holder.cardCollectionDescription.text = item.description
        holder.editButton.setOnClickListener { view ->
//            Log.i("tetete", item.cardCollectionId.toString())
            view.findNavController().navigate(CardCollectionListFragmentDirections.actionCardCollectionListFragmentToCardCollectionFragment(item.cardCollectionId))
        }
        holder.card.setOnClickListener {
            TransitionManager.beginDelayedTransition(holder.card, AutoTransition())
            holder.binding.cardCollectionDescriptionLinearLayout.isGone =
                    !holder.binding.cardCollectionDescriptionLinearLayout.isGone
        }
        holder.card.setOnLongClickListener {
            MaterialAlertDialogBuilder(holder.card.context)
                    .setMessage("Delete card collection?")
                    .setPositiveButton("CANCEL") { _, _ ->

                    }
                    .setNegativeButton("DELETE") { _, _ ->
                        outViewModel?.deleteCardCollection(item.cardCollectionId)
                    }
                    .show()
            true
        }
//        holder.deleteButton.setOnClickListener{
//            outViewModel!!.deleteCardCollection(item.cardCollectionId)
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val binding: CardCollectionItemBinding): RecyclerView.ViewHolder(binding.root){
        var cardCollectionName = binding.cardCollectionName
        var cardCollectionDescription = binding.cardCollectionDescription
        var editButton = binding.editButton
        var card = binding.card
    }
}