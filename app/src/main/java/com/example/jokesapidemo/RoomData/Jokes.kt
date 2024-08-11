package com.example.jokesapidemo.RoomData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class Jokes(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val joke: String? = null,
    val setup: String? = null,
    val delivery: String? = null,
    val type: String

)