package com.eduardg.quizlec.testscreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import com.eduardg.quizlec.training.choosecardcollection.ChooseCardCollectionViewModel
import java.lang.IllegalArgumentException

class TestScreenSelectCollectionViewModelFactory(
    private val dataSource: CardCollectionDatabaseDao,
    private val application: Application
): ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TestScreenSelectCollectionViewModel::class.java)){
            return TestScreenSelectCollectionViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}