package com.example.newsfeed.domain.entity.repository

import com.example.newsfeed.domain.entity.entity.NewsEntity
import io.reactivex.Single

interface Repository {

    fun getNews(page: Int): Single<List<NewsEntity>>
}