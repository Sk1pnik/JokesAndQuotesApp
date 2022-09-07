package com.skipnik.jokeapp.sl

import androidx.lifecycle.ViewModel
import com.skipnik.jokeapp.presentation.BaseViewModel

interface Module<T : ViewModel> {
    fun getViewModel(): T

    abstract class Base<E, T : BaseViewModel<E>> : Module<T>
}