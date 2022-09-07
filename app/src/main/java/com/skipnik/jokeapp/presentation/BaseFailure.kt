package com.skipnik.jokeapp.presentation

import androidx.annotation.StringRes
import com.skipnik.jokeapp.R
import com.skipnik.jokeapp.core.ResourceManager
import com.skipnik.jokeapp.core.presentation.Failure

abstract class BaseFailure(private val resourceManager: ResourceManager) : Failure {

    @StringRes
    protected abstract fun getMessageResId(): Int

    override fun getMessage(): String = resourceManager.getString(getMessageResId())
}

class NoConnection(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_connection
}

class ServiceUnavailable(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.service_unavailable
}

class NoCachedData(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.no_cached_data
}

class GenericError(resourceManager: ResourceManager) : BaseFailure(resourceManager) {
    override fun getMessageResId() = R.string.generic_fail_message
}