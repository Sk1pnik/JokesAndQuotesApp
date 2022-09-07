package com.skipnik.jokeapp.data

import com.skipnik.jokeapp.core.data.CommonDataModelMapper
import com.skipnik.jokeapp.domain.CommonItem

class CommonSuccessMapper<E> : CommonDataModelMapper<CommonItem.Success<E>, E> {
    override fun map(id: E, first: String, second: String, cached: Boolean) =
        CommonItem.Success(id, first, second, cached)
}