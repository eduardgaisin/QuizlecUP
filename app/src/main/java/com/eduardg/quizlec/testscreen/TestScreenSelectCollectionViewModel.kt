package com.eduardg.quizlec.testscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class TestScreenSelectCollectionViewModel (
        val database: CardCollectionDatabaseDao,
        application: Application
    ) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    val allCardCollections = database.getAllCardCollections()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}