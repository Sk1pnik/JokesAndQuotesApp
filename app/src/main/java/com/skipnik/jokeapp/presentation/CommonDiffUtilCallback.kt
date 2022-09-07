package com.skipnik.jokeapp.presentation

import androidx.recyclerview.widget.DiffUtil

class CommonDiffUtilCallback<E>(
    private val oldList: List<CommonUiModel<E>>,
    private val newList: List<CommonUiModel<E>>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].same(newList[newItemPosition])
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = false
}