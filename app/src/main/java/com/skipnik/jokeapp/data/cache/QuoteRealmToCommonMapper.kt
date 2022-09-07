package com.skipnik.jokeapp.data.cache

import com.skipnik.jokeapp.data.CommonDataModel
import com.skipnik.jokeapp.core.data.cache.RealmToCommonDataMapper

class QuoteRealmToCommonMapper : RealmToCommonDataMapper<QuoteRealmModel, String> {
    override fun map(realmObject: QuoteRealmModel) =
        CommonDataModel(realmObject.id, realmObject.content, realmObject.author, true)
}