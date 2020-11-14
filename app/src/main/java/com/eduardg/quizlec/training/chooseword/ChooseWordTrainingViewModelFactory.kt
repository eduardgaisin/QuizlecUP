package com.eduardg.quizlec.training.chooseword

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.cardcollection.CardCollectionViewModel
import com.eduardg.quizlec.database.card.CardDatabaseDao
import java.lang.IllegalArgumentException


class ChooseWordTrainingViewModelFactory(
        private val dataSource: CardDatabaseDao,
        private val application: Application,
        private val cardCollectionId: Long): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ChooseWordTrainingViewModel::class.java)){
            return ChooseWordTrainingViewModel(dataSource, application, cardCollectionId) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}