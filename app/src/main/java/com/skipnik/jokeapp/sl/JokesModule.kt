package com.skipnik.jokeapp.sl

import com.skipnik.jokeapp.data.BaseRepository
import com.skipnik.jokeapp.data.CommonSuccessMapper
import com.skipnik.jokeapp.data.cache.BaseCachedData
import com.skipnik.jokeapp.data.cache.JokeCachedDataSource
import com.skipnik.jokeapp.data.cache.JokeRealmToCommonMapper
import com.skipnik.jokeapp.data.mapper.JokeRealmMapper
import com.skipnik.jokeapp.data.net.BaseJokeService
import com.skipnik.jokeapp.data.net.JokeCloudDataSource
import com.skipnik.jokeapp.domain.BaseInteractor
import com.skipnik.jokeapp.presentation.BaseCommunication
import com.skipnik.jokeapp.presentation.JokesViewModel

class JokesModule(
    private val instancesProvider: CommonInstancesProvider
) : Module.Base<Int, JokesViewModel>() {

    override fun getViewModel() = JokesViewModel(getInteractor(), BaseCommunication())

    private fun getInteractor() =
        BaseInteractor(
            getRepository(),
            instancesProvider.provideFailureHandler(),
            CommonSuccessMapper()
        )

    private fun getRepository() =
        BaseRepository(getCacheDataSource(), getCloudDataSource(), BaseCachedData())

    private fun getCacheDataSource() =
        JokeCachedDataSource(instancesProvider, JokeRealmMapper(), JokeRealmToCommonMapper())

    private fun getCloudDataSource() =
        JokeCloudDataSource(instancesProvider.makeService(BaseJokeService::class.java))
}