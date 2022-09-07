package com.skipnik.jokeapp.core.data

interface CommonDataModelMapper<T, E> {
    fun map(id: E, first: String, second: String, cached: Boolean): T
}