package com.skipnik.jokeapp.core.data

import com.skipnik.jokeapp.data.CommonDataModel
import java.lang.IllegalStateException

interface ChangeCommonItem<E> {
    suspend fun change(changeStatus: ChangeStatus<E>): CommonDataModel<E>

    class Empty<E> : ChangeCommonItem<E> {
        override suspend fun change(changeStatus: ChangeStatus<E>): CommonDataModel<E> {
            throw IllegalStateException("empty change item called")
        }
    }
}