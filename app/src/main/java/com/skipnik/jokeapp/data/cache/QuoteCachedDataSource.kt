package com.skipnik.jokeapp.data.cache

import com.skipnik.jokeapp.core.data.cache.RealmProvider
import com.skipnik.jokeapp.data.mapper.QuoteRealmMapper
import io.realm.Realm

class QuoteCachedDataSource(
    realmProvider: RealmProvider,
    mapper: QuoteRealmMapper,
    commonDataMapper: QuoteRealmToCommonMapper
) : BaseCachedDataSource<QuoteRealmModel, String>(realmProvider, mapper, commonDataMapper) {
    override val dbClass = QuoteRealmModel::class.java
    override fun findRealmObject(realm: Realm, id: String) =
        realm.where(dbClass).equalTo("id", id).findFirst()
}