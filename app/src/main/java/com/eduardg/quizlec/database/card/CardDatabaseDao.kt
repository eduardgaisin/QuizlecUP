package com.eduardg.quizlec.database.card

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CardDatabaseDao{
    @Insert
    fun insert(card: Card)

    @Update
    fun update(card: Card)

    @Query(value = "SELECT * FROM user_cards_table WHERE cardId = :key")
    fun getCard(key: Long): Card

    @Query(value = "SELECT * FROM user_cards_table ORDER BY RANDOM() LIMIT 1")
    fun getRandCard(): Card

    @Query(value = "SELECT * FROM user_cards_table WHERE collection_id = :key ORDER BY term ASC")
    fun getAllCardsId(key: Long): LiveData<MutableList<Card>>

    @Query(value = "SELECT * FROM user_cards_table ORDER BY cardId DESC LIMIT 1")
    fun getLastCard(): Card


    @Query(value = "DELETE FROM user_cards_table WHERE cardId = :key")
    fun clearCard(key: Long)

    @Query(value = "DELETE FROM user_cards_table")
    fun clear()


}