package com.skipnik.jokeapp.data.cache

import com.skipnik.jokeapp.data.CommonDataModel
import com.skipnik.jokeapp.core.data.cache.RealmToCommonDataMapper

class JokeRealmToCommonMapper : RealmToCommonDataMapper<JokeRealmModel, Int> {
    override fun map(realmObject: JokeRealmModel) =
        CommonDataModel(realmObject.id, realmObject.text, realmObject.punchLine, true)
}