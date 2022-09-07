package com.skipnik.jokeapp.core.data.cache

import io.realm.Realm

interface RealmProvider {

    fun provide(): Realm
}

