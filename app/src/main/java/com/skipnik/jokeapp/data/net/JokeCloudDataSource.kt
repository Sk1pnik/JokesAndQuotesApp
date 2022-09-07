package com.skipnik.jokeapp.data.net

class JokeCloudDataSource(private val service: BaseJokeService) :
    BaseCloudDataSource<JokeServerModel, Int>() {
    override fun getServerModel() = service.getJoke()
}