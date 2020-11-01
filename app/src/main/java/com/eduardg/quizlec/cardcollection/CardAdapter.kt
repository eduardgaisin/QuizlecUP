package com.eduardg.quizlec.cardcollection

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.R
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
        holder.frontText.text = item.frontText
        holder.backText.text = item.backText
        holder.deleteButton.setOnClickListener {
            outViewModel!!.deleteCard(item.cardId)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
        val frontText: TextView = binding.frontCardText
        val backText: TextView = binding.backCardText
        val deleteButton: Button = binding.deleteCardButton
    }

}