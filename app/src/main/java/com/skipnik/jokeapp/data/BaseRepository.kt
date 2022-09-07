package com.skipnik.jokeapp.data

import com.skipnik.jokeapp.core.data.DataFetcher
import com.skipnik.jokeapp.core.data.CommonRepository
import com.skipnik.jokeapp.core.data.cache.CacheDataSource
import com.skipnik.jokeapp.core.data.cache.CachedData
import com.skipnik.jokeapp.core.data.net.CloudDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseRepository<E>(
    private val cacheDataSource: CacheDataSource<E>,
    private val cloudDataSource: CloudDataSource<E>,
    private val cached: CachedData<E>
) : CommonRepository<E> {
    private var currentDataSource: DataFetcher<E> = cloudDataSource
    override fun chooseDataSource(cached: Boolean) {
        currentDataSource = if (cached) cacheDataSource else cloudDataSource
    }

    override suspend fun getCommonItemList(): List<CommonDataModel<E>> =
        withContext(Dispatchers.IO) {
            cacheDataSource.getDataList()
        }

    override suspend fun getCommonItem(): CommonDataModel<E> = withContext(Dispatchers.IO) {
        try {
            val data = currentDataSource.getData()
            cached.save(data)
            return@withContext data
        } catch (e: Exception) {
            cached.clear()
            throw e
        }
    }

    override suspend fun changeStatus(): CommonDataModel<E> = cached.change(cacheDataSource)

    override suspend fun removeItem(id: E) {
        cacheDataSource.remove(id)
    }
}