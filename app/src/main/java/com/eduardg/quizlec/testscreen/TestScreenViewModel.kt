package com.eduardg.quizlec.testscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.eduardg.quizlec.database.card.CardDatabaseDao
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class TestScreenViewModel (
    val database: CardDatabaseDao,
    application: Application,
    cardCollectionId: Long
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    val allCardCollections = database.getAllCardsId(cardCollectionId)
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}