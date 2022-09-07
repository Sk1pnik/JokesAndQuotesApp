package com.skipnik.jokeapp.core.domain

import com.skipnik.jokeapp.core.presentation.Failure

interface FailureHandler {
    fun handle(e: Exception): Failure
}
