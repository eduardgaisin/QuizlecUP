package com.eduardg.quizlec.cardcollection

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.database.card.CardDatabaseDao
import java.lang.IllegalArgumentException

class CardCollectionViewModelFactory(
        private val dataSource: CardDatabaseDao,
        private val application: Application): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CardCollectionViewModel::class.java)){
            return CardCollectionViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}
