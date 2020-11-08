package com.eduardg.quizlec.database.card

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_cards_table")
data class Card(
        @PrimaryKey(autoGenerate = true)
        var cardId: Long = 0L,

        @ColumnInfo(name = "term")
        var term: String = "0",

        @ColumnInfo(name = "definition")
        var definition: String = "0",

        @ColumnInfo(name = "collection_id")
        var collectionId: Long = 0L
)