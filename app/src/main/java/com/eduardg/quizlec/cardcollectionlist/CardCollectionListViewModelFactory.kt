package com.eduardg.quizlec.cardcollectionlist

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.cardcollection.CardCollectionViewModel
import com.eduardg.quizlec.database.card.CardDatabaseDao
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import java.lang.IllegalArgumentException

class CardCollectionListViewModelFactory(
    private val dataSource: CardCollectionDatabaseDao,
    private val application: Application
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardCollectionListViewModel::class.java)){
            return CardCollectionListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}