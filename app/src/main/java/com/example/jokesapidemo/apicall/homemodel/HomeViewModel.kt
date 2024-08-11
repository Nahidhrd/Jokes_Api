package com.example.jokesapidemo.apicall.homemodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jokesapidemo.RoomData.DefaultJokesRepository
import com.example.jokesapidemo.RoomData.Jokes
import com.example.jokesapidemo.apicall.JokesClient
import com.example.jokesapidemo.apicall.ResponseJokes

import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val responseJokesData = MutableLiveData<ResponseJokes>()
    val _responseJokesData get() = responseJokesData

    private val emptyValue = ""
    val jokeSetup = MutableLiveData<String>()
    val delivery = MutableLiveData<String>()
    val categories = MutableLiveData<String>()
    private val repository: DefaultJokesRepository = DefaultJokesRepository.getInstance(application)
    private lateinit var jokesData: Jokes

    fun getRandomJokes(category: String) {
        viewModelScope.launch {
            val response = when (category) {
                "Any" -> JokesClient.JokesApiService.getRandomJoke()
                "Programming" -> JokesClient.JokesApiService.getProgrammingJoke()
                "Miscellaneous" -> JokesClient.JokesApiService.getMiscellaneousJoke()
                "Dark" -> JokesClient.JokesApiService.getDarkJoke()
                "Pun" -> JokesClient.JokesApiService.getPunJoke()
                "Spooky" -> JokesClient.JokesApiService.getSpookyJoke()
                "Christmas" -> JokesClient.JokesApiService.getChristmasJoke()
                else -> JokesClient.JokesApiService.getRandomJoke()
            }
            if (response.isSuccessful) {
                responseJokesData.postValue(response.body())
            }
        }

    }

    fun saveJokes() {
        val jokeSetup = jokeSetup.value
        val delivery = delivery.value

        if (jokeSetup == emptyValue){
            jokesData = Jokes(
                joke = delivery,
                type = categories.value.toString()
            )
        }else{
            jokesData = Jokes(
                setup = jokeSetup,
                delivery = delivery,
                type = categories.value.toString()
            )
        }

        saveJokes(jokesData)

    }

    private fun saveJokes(jokesData: Jokes){
        viewModelScope.launch{
            repository.saveJokes(jokesData)
        }
    }
}


