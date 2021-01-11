package com.eduardg.quizlec.training.chooseword

import android.app.Application
import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.database.card.CardDatabaseDao
import kotlinx.coroutines.*
import java.util.concurrent.CountDownLatch
import kotlin.random.Random

class ChooseWordTrainingViewModel(
        val database: CardDatabaseDao,
        application: Application,
        val cardCollectionId: Long) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val timer: CountDownTimer
    val isFinished = MutableLiveData<Boolean>(false)
    val remainingTime = MutableLiveData<String>()
    val allCards = database.getAllCardsId(cardCollectionId)
    var questionTerm = MutableLiveData<String>()
    var firstAnswer = MutableLiveData<String>()
    var secondAnswer = MutableLiveData<String>()
    var thirdAnswer = MutableLiveData<String>()
    var fourthAnswer = MutableLiveData<String>()
    var currentCard = MutableLiveData<Card>()
    private var rightAnswer = 0
    var rightAnswerCounter = -1
    var questionsCounter = -1

    init{
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){
            override fun onTick(millisUntilFinished: Long) {
                remainingTime.value = DateUtils.formatElapsedTime(millisUntilFinished/1000)
            }
            override fun onFinish() {
                isFinished.value = true
            }
        }
        answer(-1)
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        timer.cancel()
    }
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun nextQuestion(){
        currentCard.value = allCards.value?.random() ?: Card()
        questionTerm.value = currentCard.value!!.term
        rightAnswer = Random.nextInt(0, 4)
        when(rightAnswer){
            0 -> firstAnswer.value = currentCard.value!!.definition
            1 -> secondAnswer.value = currentCard.value!!.definition
            2 -> thirdAnswer.value = currentCard.value!!.definition
            3 -> fourthAnswer.value = currentCard.value!!.definition
        }
        for(i in 0..3){
            if(i == rightAnswer){
                continue
            }
            var wrongAnswer: String = ""
            while(true){
                wrongAnswer = allCards.value?.random()?.definition ?: ""
//                if(allCards.value!!.size <= 1) break
                if(wrongAnswer != currentCard.value?.definition){
                    break
                }
            }
            when(i){
                0 -> firstAnswer.value = wrongAnswer
                1 -> secondAnswer.value = wrongAnswer
                2 -> thirdAnswer.value = wrongAnswer
                3 -> fourthAnswer.value = wrongAnswer
            }
        }
    }

    fun answer(userAnswer: Int): Boolean{
        var ans = (userAnswer == rightAnswer)
        nextQuestion()
        questionsCounter++
        if(ans) rightAnswerCounter++
        return ans
    }

    companion object{
        private const val DONE = 0L
        private const val ONE_SECOND = 1000L
        private const val COUNTDOWN_TIME = 60000L
    }

}