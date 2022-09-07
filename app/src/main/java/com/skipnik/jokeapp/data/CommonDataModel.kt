package com.skipnik.jokeapp.data

import com.skipnik.jokeapp.core.data.ChangeCommonItem
import com.skipnik.jokeapp.core.data.ChangeStatus
import com.skipnik.jokeapp.core.data.CommonDataModelMapper

class CommonDataModel<E>(
    private val id: E,
    private val firstText: String,
    private val secondText: String,
    private val cached: Boolean = false
) : ChangeCommonItem<E> {

    fun <T> map(mapper: CommonDataModelMapper<T, E>): T {
        return mapper.map(id, firstText, secondText, cached)
    }

    override suspend fun change(changeStatus: ChangeStatus<E>) = changeStatus.addOrRemove(id, this)

    fun changeCached(cached: Boolean) = CommonDataModel(id, firstText, secondText, cached)
}