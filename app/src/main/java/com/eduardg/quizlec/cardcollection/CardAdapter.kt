package com.eduardg.quizlec.cardcollection

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.databinding.CardItemBinding

class CardAdapter: RecyclerView.Adapter<CardAdapter.ViewHolder>(){

    var outViewModel: CardCollectionViewModel? = null

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
            outViewModel!!.deleteCard(item.cardId)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
        val term: TextView = binding.frontCardText
        val definition: TextView = binding.backCardText
        val deleteButton: ImageButton = binding.deleteCardButton
    }

}