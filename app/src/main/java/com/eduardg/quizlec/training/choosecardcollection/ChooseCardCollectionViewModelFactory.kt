package com.eduardg.quizlec.training.choosecardcollection

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.database.card.CardDatabaseDao
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import com.eduardg.quizlec.training.writeword.WriteWordTrainingViewModel
import java.lang.IllegalArgumentException

class ChooseCardCollectionViewModelFactory(
        private val dataSource: CardCollectionDatabaseDao,
        private val application: Application): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ChooseCardCollectionViewModel::class.java)){
            return ChooseCardCollectionViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}