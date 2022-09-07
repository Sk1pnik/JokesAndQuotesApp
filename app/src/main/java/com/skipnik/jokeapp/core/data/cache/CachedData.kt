package com.skipnik.jokeapp.core.data.cache

import com.skipnik.jokeapp.data.CommonDataModel
import com.skipnik.jokeapp.core.data.ChangeCommonItem

interface CachedData<E> : ChangeCommonItem<E> {
    fun save(data: CommonDataModel<E>)
    fun clear()
}