package com.skipnik.jokeapp.domain

import com.skipnik.jokeapp.core.ResourceManager
import com.skipnik.jokeapp.core.domain.FailureHandler
import com.skipnik.jokeapp.core.domain.NoCachedDataException
import com.skipnik.jokeapp.core.domain.NoConnectionException
import com.skipnik.jokeapp.core.domain.ServiceUnavailableException
import com.skipnik.jokeapp.presentation.*

class FailureFactory(private val resourceManager: ResourceManager) : FailureHandler {
    override fun handle(e: Exception) = when (e) {
        is NoConnectionException -> NoConnection(resourceManager)
        is NoCachedDataException -> NoCachedData(resourceManager)
        is ServiceUnavailableException -> ServiceUnavailable(resourceManager)
        else -> GenericError(resourceManager)
    }
}