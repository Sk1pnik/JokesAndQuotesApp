package com.skipnik.jokeapp.sl

import com.skipnik.jokeapp.presentation.MainViewModel
import com.skipnik.jokeapp.presentation.NavigationCommunication
import com.skipnik.jokeapp.presentation.ScreenPosition

class MainModule(private val commonInstancesProvider: CommonInstancesProvider) : Module<MainViewModel> {

    override fun getViewModel() = MainViewModel(
        ScreenPosition.Base(commonInstancesProvider.providePersistentDataSource()),
        NavigationCommunication.Base()
    )
}