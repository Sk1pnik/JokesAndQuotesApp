package com.skipnik.jokeapp.core.data.cache

import com.skipnik.jokeapp.data.CommonDataModel
import io.realm.RealmObject

interface RealmToCommonDataMapper<T : RealmObject, E> {

    fun map(realmObject: T): CommonDataModel<E>
}