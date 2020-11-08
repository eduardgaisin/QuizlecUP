package com.eduardg.quizlec.database.cardcollection

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_collection_list_table")
data class CardCollection(
    @PrimaryKey(autoGenerate = true)
    var cardCollectionId: Long = 0L,

    @ColumnInfo(name = "user_id")
    var userId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "description")
    var description: String = ""
)