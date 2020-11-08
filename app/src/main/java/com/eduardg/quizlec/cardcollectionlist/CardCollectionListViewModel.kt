package com.eduardg.quizlec.cardcollectionlist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.eduardg.quizlec.database.card.CardDatabaseDao
import com.eduardg.quizlec.database.cardcollection.CardCollection
import com.eduardg.quizlec.database.cardcollection.CardCollectionDatabaseDao
import kotlinx.coroutines.*

class CardCollectionListViewModel(
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

    fun addCardCollection(name: String, description: String){
        uiScope.launch {
            withContext(Dispatchers.IO){
                database.insert(CardCollection(0, 0, name, description))
            }
        }
    }


}