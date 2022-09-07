package com.skipnik.jokeapp.data.net

import com.skipnik.jokeapp.data.CommonDataModel
import com.skipnik.jokeapp.core.Mapper
import com.skipnik.jokeapp.core.data.net.CloudDataSource
import com.skipnik.jokeapp.core.domain.NoConnectionException
import com.skipnik.jokeapp.core.domain.ServiceUnavailableException
import retrofit2.Call
import java.net.UnknownHostException

abstract class BaseCloudDataSource<T : Mapper<CommonDataModel<E>>, E> : CloudDataSource<E> {
    protected abstract fun getServerModel(): Call<T>
    override suspend fun getData(): CommonDataModel<E> {
        try {
            return getServerModel().execute().body()!!.to()
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }
}