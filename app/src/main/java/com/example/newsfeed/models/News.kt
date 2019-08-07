package com.example.newsfeed.models

import com.google.gson.annotations.SerializedName

class News (
    @SerializedName("status") val status: String,
    @SerializedName("totalResult") val totalResult: Int,
    @SerializedName("articles") val article: List<Article>
)