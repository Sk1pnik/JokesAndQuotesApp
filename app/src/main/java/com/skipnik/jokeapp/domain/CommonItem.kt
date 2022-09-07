package com.skipnik.jokeapp.domain

import com.skipnik.jokeapp.core.Mapper
import com.skipnik.jokeapp.presentation.CommonUiModel
import com.skipnik.jokeapp.core.presentation.Failure
import com.skipnik.jokeapp.presentation.*

sealed class CommonItem<E> : Mapper<CommonUiModel<E>> {
    class Success<E>(
        private val id: E,
        private val firstText: String,
        private val secondText: String,
        private val favorite: Boolean
    ) : CommonItem<E>() {
        override fun to() = if (favorite) {
            FavoriteCommonUiModel(id, firstText, secondText)
        } else {
            BaseCommonUiModel(firstText, secondText)
        }
    }

    class Failed<E>(private val failure: Failure) : CommonItem<E>() {
        override fun to(): CommonUiModel<E> = FailedCommonUiModel(failure.getMessage())
    }
}