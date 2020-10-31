package com.eduardg.quizlec.database.card

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Card::class], version = 1, exportSchema = false)
abstract class CardDatabase : RoomDatabase(){
    abstract val cardDatabaseDao: CardDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: CardDatabase? = null

        fun getInstance(context: Context): CardDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CardDatabase::class.java,
                        "cards_database"
                    ).fallbackToDestructiveMigration().build()
                }
                return instance
            }
        }
    }
}