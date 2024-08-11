package com.example.jokesapidemo.RoomData

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DefaultJokesRepository private constructor(application: Application) {

    private val localDataSource: LocalDataSource
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    init {
        localDataSource = LocalDataSource(JokesDataBase.getInstance(application.applicationContext).jokesDao())
    }

    companion object {

        private var reprository : DefaultJokesRepository?= null

        fun getInstance(application: Application) :DefaultJokesRepository {
            if (reprository == null){
                reprository = DefaultJokesRepository(application)

                return reprository as DefaultJokesRepository
            }
            return reprository as DefaultJokesRepository
        }
    }

    suspend fun saveJokes(jokes: Jokes) {
        withContext(ioDispatcher){
            localDataSource.saveJokes(jokes)
        }
    }

      fun getAllTJokes(): LiveData<List<Jokes>> {
        return localDataSource.getAllTJokes()
    }

    suspend fun deleteByJokes(jokes: Jokes) {
        withContext(ioDispatcher){
            localDataSource.deleteByJokes(jokes)
        }
    }
}