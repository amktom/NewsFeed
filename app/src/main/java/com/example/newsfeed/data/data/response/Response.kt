package com.example.newsfeed.data.data.response

import com.example.newsfeed.data.data.models.News
import com.google.gson.annotations.SerializedName

data class Response(@SerializedName("articles") val response: List<News>)