package com.eduardg.quizlec.training.writeword

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.database.card.CardDatabaseDao
import java.lang.IllegalArgumentException

class WriteWordTrainingViewModelFactory(
        private val dataSource: CardDatabaseDao,
        private val application: Application,
        private val cardCollectionId: Long): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WriteWordTrainingViewModel::class.java)){
            return WriteWordTrainingViewModel(dataSource, application, cardCollectionId) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}