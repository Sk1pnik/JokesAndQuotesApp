package com.skipnik.jokeapp.sl

import com.skipnik.jokeapp.data.BaseRepository
import com.skipnik.jokeapp.data.CommonSuccessMapper
import com.skipnik.jokeapp.data.cache.BaseCachedData
import com.skipnik.jokeapp.data.cache.QuoteCachedDataSource
import com.skipnik.jokeapp.data.cache.QuoteRealmToCommonMapper
import com.skipnik.jokeapp.data.mapper.QuoteRealmMapper
import com.skipnik.jokeapp.data.net.QuoteCloudDataSource
import com.skipnik.jokeapp.data.net.QuoteService
import com.skipnik.jokeapp.domain.BaseInteractor
import com.skipnik.jokeapp.presentation.BaseCommunication
import com.skipnik.jokeapp.presentation.QuotesViewModel

class QuotesModule(private val instancesProvider: CommonInstancesProvider) :
    Module.Base<String, QuotesViewModel>() {

    override fun getViewModel() = QuotesViewModel(getInteractor(), BaseCommunication())

    private fun getInteractor() =
        BaseInteractor(
            getRepository(),
            instancesProvider.provideFailureHandler(),
            CommonSuccessMapper()
        )

    private fun getRepository() = BaseRepository(
        getCacheDataSource(),
        getCloudDataSource(),
        BaseCachedData()
    )

    private fun getCacheDataSource() =
        QuoteCachedDataSource(instancesProvider, QuoteRealmMapper(), QuoteRealmToCommonMapper())

    private fun getCloudDataSource() =
        QuoteCloudDataSource(instancesProvider.makeService(QuoteService::class.java))
}