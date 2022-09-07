package com.skipnik.jokeapp.core.domain

import com.skipnik.jokeapp.domain.CommonItem

interface CommonInteractor<T> {
    suspend fun getItem(): CommonItem<T>
    suspend fun getItemList() : List<CommonItem<T>>
    suspend fun changeFavorites(): CommonItem<T>
    fun getFavorites(favorites: Boolean)
    suspend fun removeItem(id: T)
}