package com.eduardg.quizlec.training.choosecardcollection

import android.app.ProgressDialog.show
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.eduardg.quizlec.cardcollectionlist.CardCollectionAdapter
import com.eduardg.quizlec.cardcollectionlist.CardCollectionListFragmentDirections
import com.eduardg.quizlec.cardcollectionlist.CardCollectionListViewModel
import com.eduardg.quizlec.database.cardcollection.CardCollection
import com.eduardg.quizlec.databinding.CardCollectionItemBinding
import com.eduardg.quizlec.databinding.SelectCardCollectionItemBinding
import kotlinx.coroutines.withContext

class ChooseCardCollectionAdapter(val fragmentManager: FragmentManager): RecyclerView.Adapter<ChooseCardCollectionAdapter.ViewHolder>() {

    var data = listOf<CardCollection>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SelectCardCollectionItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.cardCollectionName.text = item.name
//        holder.clickableLayout.setOnClickListener {view ->
//            view.findNavController().navigate(ChooseCardCollectionFragmentDirections.actionChooseCardCollectionFragmentToChooseTrainingFragment(item.cardCollectionId))
//        }
        holder.clickableLayout.setOnClickListener {
            ChooseTrainingDialog(item.cardCollectionId).show(fragmentManager , "ChooseTrainingDialog")
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(val binding: SelectCardCollectionItemBinding): RecyclerView.ViewHolder(binding.root){
        var cardCollectionName = binding.cardCollectionNameText
        var clickableLayout = binding.chooseCardCollectionItemLayout
    }
}