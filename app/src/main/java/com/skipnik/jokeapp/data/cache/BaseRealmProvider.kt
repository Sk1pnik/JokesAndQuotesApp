package com.skipnik.jokeapp.data.cache

import android.content.Context
import com.skipnik.jokeapp.core.data.cache.RealmProvider
import io.realm.Realm

class BaseRealmProvider(context: Context) : RealmProvider {
    init {
        Realm.init(context)
    }
    override fun provide(): Realm = Realm.getDefaultInstance()
}