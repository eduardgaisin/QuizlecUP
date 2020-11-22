package com.eduardg.quizlec.cardcollection

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.databinding.CardItemBinding

class CardAdapter(val fragmentManager: FragmentManager, val viewModel: CardCollectionViewModel): RecyclerView.Adapter<CardAdapter.ViewHolder>(){

    var data = listOf<Card>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.term.text = item.term
        holder.definition.text = item.definition
        holder.deleteButton.setOnClickListener {
            this.viewModel!!.deleteCard(item.cardId)
        }
        holder.editButton.setOnClickListener {
            EditCardDialog(item, this.viewModel).show(fragmentManager , "EditCardDialog")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
        val term: TextView = binding.frontCardText
        val definition: TextView = binding.backCardText
        val deleteButton: ImageButton = binding.deleteCardButton
        val editButton = binding.editCardConstraintLayout
    }

}