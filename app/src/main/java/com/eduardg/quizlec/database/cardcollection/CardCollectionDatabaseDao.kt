package com.eduardg.quizlec.database.cardcollection

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.eduardg.quizlec.database.card.Card

@Dao
interface CardCollectionDatabaseDao{

    @Insert
    fun insert(cardCollection: CardCollection)

    @Update
    fun update(cardCollection: CardCollection)

    @Query(value = "SELECT * FROM card_collection_list_table ORDER BY cardCollectionId ASC")
    fun getAllCardCollections(): LiveData<MutableList<CardCollection>>

    @Query(value = "DELETE FROM card_collection_list_table WHERE cardCollectionId = :key")
    fun deleteCardCollection(key: Long)

    @Query(value = "DELETE FROM card_collection_list_table")
    fun clear()
}