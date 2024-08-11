package com.example.jokesapidemo.apicall.FavViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.jokesapidemo.RoomData.DefaultJokesRepository
import com.example.jokesapidemo.RoomData.Jokes
import kotlinx.coroutines.launch

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DefaultJokesRepository = DefaultJokesRepository.getInstance(application)

    var getAllJokes: LiveData<List<Jokes>> = repository.getAllTJokes()

    fun deleteJokes(jokesData: Jokes){
        viewModelScope.launch{
            repository.deleteByJokes(jokesData)
        }
    }
}