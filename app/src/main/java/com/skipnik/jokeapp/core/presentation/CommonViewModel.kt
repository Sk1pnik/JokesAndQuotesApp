package com.skipnik.jokeapp.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.skipnik.jokeapp.presentation.CommonUiModel
import com.skipnik.jokeapp.presentation.State

interface CommonViewModel<T> : CommonItemViewModel {
    fun changeItemStatus(id: T)
    fun observe(owner: LifecycleOwner, observer: Observer<State>)
    fun observeList(owner: LifecycleOwner, observer: Observer<List<CommonUiModel<T>>>)
}

interface CommonItemViewModel {
    fun getItem()
    fun getItemList()
    fun changeItemStatus()
    fun chooseFavorites(favorites: Boolean)
}