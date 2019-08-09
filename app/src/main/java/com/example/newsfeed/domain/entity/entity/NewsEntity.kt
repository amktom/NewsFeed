package com.example.newsfeed.domain.entity.entity

data class NewsEntity(
    val title: String,
    val description: String,
    val publishedAt: String,
    val urlImg: String,
    val url: String
)