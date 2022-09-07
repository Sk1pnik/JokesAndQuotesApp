package com.skipnik.jokeapp.data.net

import com.skipnik.jokeapp.core.Mapper
import com.skipnik.jokeapp.data.CommonDataModel
import com.google.gson.annotations.SerializedName

data class JokeServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("type")
    private val type: String,
    @SerializedName("setup")
    private val text: String,
    @SerializedName("punchline")
    private val punchline: String
) : Mapper<CommonDataModel<Int>> {
    override fun to() = CommonDataModel(id, text, punchline)
}