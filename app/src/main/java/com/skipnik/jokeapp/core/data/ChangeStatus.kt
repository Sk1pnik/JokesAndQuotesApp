package com.skipnik.jokeapp.core.data

import com.skipnik.jokeapp.data.CommonDataModel

interface ChangeStatus<E> {
    suspend fun addOrRemove(id: E, model: CommonDataModel<E>): CommonDataModel<E>
}