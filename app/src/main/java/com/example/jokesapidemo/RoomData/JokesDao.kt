package com.example.jokesapidemo.RoomData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface JokesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJoke(jokes: Jokes)

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): LiveData<List<Jokes>>

    @Delete
    suspend fun deleteByJokes(jokes: Jokes)

}