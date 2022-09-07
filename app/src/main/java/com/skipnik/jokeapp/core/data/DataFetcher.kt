package com.skipnik.jokeapp.core.data

import com.skipnik.jokeapp.data.CommonDataModel

interface DataFetcher<E> {
    suspend fun getData(): CommonDataModel<E>
}