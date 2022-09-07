package com.skipnik.jokeapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.skipnik.jokeapp.sl.*

class JokesAndQuotesApp : Application() {

    private val viewModelsFactory by lazy {
        ViewModelsFactory(MainModule(coreModule), JokesModule(coreModule), QuotesModule(coreModule))
    }

    private lateinit var coreModule: CoreModule

    override fun onCreate() {
        super.onCreate()
        coreModule = CoreModule(this)
    }

    fun <T : ViewModel> get(modelClass: Class<T>, owner: ViewModelStoreOwner): T =
        ViewModelProvider(owner, viewModelsFactory).get(modelClass)
}