package com.eduardg.quizlec.database.card

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_cards_table")
data class Card(
        @PrimaryKey(autoGenerate = true)
        var cardId: Long = 0L,

        @ColumnInfo(name = "front_text")
        var frontText: String = "0",

        @ColumnInfo(name = "back_text")
        var backText: String = "0"
)