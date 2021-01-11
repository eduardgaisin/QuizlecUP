package com.eduardg.quizlec.testscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.database.card.CardDatabaseDao
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import java.lang.IllegalArgumentException

class TestScreenViewModelFactory(
    private val dataSource: CardDatabaseDao,
    private val application: Application,
    private val cardCollectionId: Long
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TestScreenViewModel::class.java)){
            return TestScreenViewModel(dataSource, application, cardCollectionId) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}