package com.eduardg.quizlec.training.writeword

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.database.card.CardDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class WriteWordTrainingViewModel(
        val database: CardDatabaseDao,
        application: Application,
        val cardCollectionId: Long) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val allCards = database.getAllCardsId(cardCollectionId)
    private var currentCard: Card = Card()
    var questionTerm = MutableLiveData<String>()

    init{
        nextQuestion()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun nextQuestion(){
        currentCard  = allCards.value?.random() ?: Card()
        questionTerm.value = currentCard.term
    }

    fun checkAnswer(userAnswer: String): Boolean{
        val isRight = userAnswer == currentCard.definition
        nextQuestion()
        return isRight
    }
}