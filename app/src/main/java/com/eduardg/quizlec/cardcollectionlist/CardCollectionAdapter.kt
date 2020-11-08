package com.eduardg.quizlec.cardcollectionlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.cardcollection.CardAdapter
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.database.cardcollection.CardCollection
import com.eduardg.quizlec.databinding.CardCollectionItemBinding
import com.eduardg.quizlec.databinding.CardItemBinding

class CardCollectionAdapter: RecyclerView.Adapter<CardCollectionAdapter.ViewHolder>(){

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
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(val binding: CardCollectionItemBinding): RecyclerView.ViewHolder(binding.root){
        var cardCollectionName = binding.cardCollectionName
        var cardCollectionDescription = binding.cardCollectionDescription
    }
}