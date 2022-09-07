package com.skipnik.jokeapp.data.net

import com.skipnik.jokeapp.data.CommonDataModel
import com.skipnik.jokeapp.core.Mapper
import com.google.gson.annotations.SerializedName

class QuoteServerModel(
    @SerializedName("_id")
    private val id: String,
    @SerializedName("content")
    private val content: String,
    @SerializedName("author")
    private val author: String
) : Mapper<CommonDataModel<String>> {
    override fun to() = CommonDataModel(id, content, author)
}