package com.skipnik.jokeapp.presentation

import android.content.Context
import com.skipnik.jokeapp.core.ResourceManager

class BaseResourceManager(private val context: Context) : ResourceManager {

    override fun getString(stringResId: Int) = context.getString(stringResId)
}