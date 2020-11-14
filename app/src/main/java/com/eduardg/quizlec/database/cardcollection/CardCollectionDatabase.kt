package com.eduardg.quizlec.database.cardcollection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eduardg.quizlec.database.card.Card
import com.eduardg.quizlec.database.card.CardDatabaseDao

@Database(entities = [CardCollection::class], version = 1, exportSchema = false)
abstract class CardCollectionDatabase : RoomDatabase(){
    abstract val cardCollectionDatabaseDao: CardCollectionDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: CardCollectionDatabase? = null

        fun getInstance(context: Context): CardCollectionDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CardCollectionDatabase::class.java,
                        "card_collections_database"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}