package com.eduardg.quizlec.cardcollection

import android.app.Application
import androidx.lifecycle.*
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.database.card.CardDatabaseDao
import kotlinx.coroutines.*

class CardCollectionViewModel(
        val database: CardDatabaseDao,
        application: Application,
        val cardCollectionId: Long) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    val allCards = database.getAllCardsId(cardCollectionId)

//    var cardCollectionString = Transformations.map(allCards){allCards ->
//        formatCards(allCards)
//    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private fun formatCards(cards: List<Card>): String{
//        var beautifulString: String = ""
//        cards.forEach {
//            beautifulString += cards.indexOf(it).toString() + " " + it.term + " " + it.definition + "\n"
//        }
//        return beautifulString
//    }

    fun addCard(frontText: String, backText: String){
        uiScope.launch {
            withContext(Dispatchers.IO) {
                database.insert(Card(0, frontText, backText, cardCollectionId))
            }
        }
    }

    fun clearAllCards(){
        uiScope.launch {
            withContext(Dispatchers.IO){
                database.clear()
            }
        }
    }

    fun deleteCard(cardId: Long){
        uiScope.launch {
            withContext(Dispatchers.IO){
                database.clearCard(cardId)
            }
        }
    }

}