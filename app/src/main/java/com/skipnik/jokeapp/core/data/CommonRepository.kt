package com.skipnik.jokeapp.core.data

import com.skipnik.jokeapp.data.CommonDataModel

interface CommonRepository<E> {
    suspend fun getCommonItem(): CommonDataModel<E>
    suspend fun getCommonItemList(): List<CommonDataModel<E>>
    suspend fun changeStatus(): CommonDataModel<E>
    fun chooseDataSource(cached: Boolean)
    suspend fun removeItem(id: E)
}