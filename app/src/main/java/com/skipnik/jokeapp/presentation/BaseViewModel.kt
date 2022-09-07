package com.skipnik.jokeapp.presentation

import androidx.lifecycle.*
import com.skipnik.jokeapp.core.domain.CommonInteractor
import com.skipnik.jokeapp.core.presentation.CommonCommunication
import com.skipnik.jokeapp.core.presentation.CommonViewModel
import com.skipnik.jokeapp.core.presentation.ListChanges
import com.skipnik.jokeapp.domain.CommonItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel<T>(
    private val interactor: CommonInteractor<T>,
    private val communication: CommonCommunication<T>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), CommonViewModel<T>, ListChanges<T> {

    override fun getList() = communication.getList()
    override fun getDiffResult() = communication.getDiffResult()

    override fun getItem() {
        viewModelScope.launch(dispatcher) {
            communication.showState(State.Progress)
            interactor.getItem().to().show(communication)
        }
    }

    override fun getItemList() {
        viewModelScope.launch(dispatcher) {
            showList()
        }
    }

    override fun changeItemStatus() {
        viewModelScope.launch(dispatcher) {
            if (communication.isState(State.INITIAL)) {
                interactor.changeFavorites().to().show(communication)
                showList()
            }
        }
    }

    override fun changeItemStatus(id: T) {
        viewModelScope.launch(dispatcher) {
            interactor.removeItem(id)
            showList()
        }
    }

    private suspend fun showList() = communication.showDataList(interactor.getItemList().toUiList())

    override fun chooseFavorites(favorites: Boolean) = interactor.getFavorites(favorites)
    override fun observe(owner: LifecycleOwner, observer: Observer<State>) =
        communication.observe(owner, observer)

    override fun observeList(
        owner: LifecycleOwner,
        observer: Observer<List<CommonUiModel<T>>>
    ) = communication.observeList(owner, observer)
}

fun <T> List<CommonItem<T>>.toUiList() = map { it.to() }

class JokesViewModel(
    interactor: CommonInteractor<Int>,
    communication: CommonCommunication<Int>
) : BaseViewModel<Int>(interactor, communication)

class QuotesViewModel(
    interactor: CommonInteractor<String>,
    communication: CommonCommunication<String>
) : BaseViewModel<String>(interactor, communication)