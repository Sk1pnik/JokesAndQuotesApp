package com.skipnik.jokeapp.data.net

import retrofit2.Call
import retrofit2.http.GET

interface BaseJokeService {
    @GET("https://official-joke-api.appspot.com/random_joke/")
    fun getJoke(): Call<JokeServerModel>
}