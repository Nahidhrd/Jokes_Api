package com.example.jokesapidemo.RoomData

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val dao: JokesDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
 ): JokesDataSource {

     override suspend fun saveJokes(jokes: Jokes) {
        withContext(ioDispatcher){
            dao.insertJoke(jokes)
        }
     }

    override fun getAllTJokes(): LiveData<List<Jokes>> {
        return dao.getAllJokes()
    }

    override suspend fun deleteByJokes(jokes: Jokes) {
        withContext(ioDispatcher){
            dao.deleteByJokes(jokes)
        }
    }
}