package com.eduardg.quizlec.cardcollection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.R
import com.eduardg.quizlec.database.card.Card

class CardAdapter: RecyclerView.Adapter<CardAdapter.ViewHolder>(){

    var data = listOf<Card>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.card_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.frontText.text = item.frontText
        holder.backText.text = item.backText
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val frontText: TextView = itemView.findViewById(R.id.front_card_text)
        val backText: TextView = itemView.findViewById(R.id.back_card_text)
        val deleteButton: Button = itemView.findViewById(R.id.delete_card_button)
    }

}