package com.skipnik.jokeapp.presentation

import com.skipnik.jokeapp.R

class JokesFragment : BaseFragment<JokesViewModel, Int>() {
    override fun checkBoxText() = R.string.show_favorite_joke
    override fun actionButtonText() = R.string.get_joke
    override fun getViewModelClass() = JokesViewModel::class.java
}