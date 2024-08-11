package com.example.jokesapidemo.RoomData

import androidx.lifecycle.LiveData

interface JokesDataSource {

    suspend fun saveJokes (jokes: Jokes)

    fun getAllTJokes(): LiveData<List<Jokes>>

    suspend fun deleteByJokes(jokes: Jokes)
}