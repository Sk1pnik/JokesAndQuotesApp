package com.skipnik.jokeapp.data.cache

import com.skipnik.jokeapp.data.CommonDataModel
import com.skipnik.jokeapp.core.data.ChangeCommonItem
import com.skipnik.jokeapp.core.data.ChangeStatus
import com.skipnik.jokeapp.core.data.cache.CachedData

class BaseCachedData<E> : CachedData<E>{
    private var cached: ChangeCommonItem<E> = ChangeCommonItem.Empty()
    override fun save(data: CommonDataModel<E>) {
        cached = data
    }

    override fun clear() {
        cached = ChangeCommonItem.Empty()
    }

    override suspend fun change(changeStatus: ChangeStatus<E>): CommonDataModel<E> {
        return cached.change(changeStatus)
    }
}