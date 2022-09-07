package com.skipnik.jokeapp.data.mapper

import com.skipnik.jokeapp.core.data.CommonDataModelMapper
import com.skipnik.jokeapp.data.cache.JokeRealmModel

class JokeRealmMapper : CommonDataModelMapper<JokeRealmModel, Int> {
    override fun map(id: Int, first: String, second: String, cached: Boolean) =
        JokeRealmModel().also { joke ->
            joke.id = id
            joke.text = first
            joke.punchLine = second
        }
}