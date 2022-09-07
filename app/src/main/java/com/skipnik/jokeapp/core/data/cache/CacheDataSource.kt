package com.skipnik.jokeapp.core.data.cache

import com.skipnik.jokeapp.core.data.DataFetcher
import com.skipnik.jokeapp.core.data.ChangeStatus
import com.skipnik.jokeapp.data.CommonDataModel

interface CacheDataSource<E> : DataFetcher<E>, ChangeStatus<E> {
    suspend fun getDataList(): List<CommonDataModel<E>>
    suspend fun remove(id: E)
}