package com.skipnik.jokeapp.data.mapper

import com.skipnik.jokeapp.core.data.CommonDataModelMapper
import com.skipnik.jokeapp.data.cache.QuoteRealmModel

class QuoteRealmMapper : CommonDataModelMapper<QuoteRealmModel, String> {
    override fun map(id: String, first: String, second: String, cached: Boolean) =
        QuoteRealmModel().also { quote ->
            quote.id = id
            quote.content = first
            quote.author = second
        }
}