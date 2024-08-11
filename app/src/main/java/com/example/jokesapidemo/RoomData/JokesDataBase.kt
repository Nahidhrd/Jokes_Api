package com.example.jokesapidemo.RoomData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Jokes::class], version = 1, exportSchema = false)
abstract class JokesDataBase : RoomDatabase() {

    abstract fun jokesDao() : JokesDao

    companion object {

        private var database: JokesDataBase? = null
        @Synchronized
        fun getInstance(context: Context): JokesDataBase{
            if (database == null) {
                database = Room.databaseBuilder(context,JokesDataBase::class.java,"jokes").build()

                return database as JokesDataBase
            }
            return database as JokesDataBase
        }
    }
}