package com.example.newsfeed.data.data.models

import com.google.gson.annotations.SerializedName
import java.util.*

class News (
    @SerializedName("title") val title: String,
    @SerializedName("description") val desription: String,
    @SerializedName("url") val url: String,
    @SerializedName("urlToImage") val urlToImage: String,
    @SerializedName("publishedAt") val publishedAt: Date
)