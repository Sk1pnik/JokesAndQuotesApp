package com.skipnik.jokeapp.sl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.skipnik.jokeapp.presentation.*
import java.lang.IllegalStateException

class ViewModelsFactory(
    private val mainModule: MainModule,
    private val jokesModule: JokesModule,
    private val quotesModule: QuotesModule
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val module = when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> mainModule
            modelClass.isAssignableFrom(JokesViewModel::class.java) -> jokesModule
            modelClass.isAssignableFrom(QuotesViewModel::class.java) -> quotesModule
            else -> throw IllegalStateException("unknown type of viewModel")
        }
        return module.getViewModel() as T
    }
}