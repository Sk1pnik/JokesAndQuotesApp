package com.skipnik.jokeapp.core

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes stringResId: Int): String
}