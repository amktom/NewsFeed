package com.example.newsfeed.data.data.repository

import com.example.newsfeed.data.data.network.Api
import com.example.newsfeed.data.data.converter.Converter
import com.example.newsfeed.data.data.response.Response
import com.example.newsfeed.domain.entity.entity.NewsEntity
import com.example.newsfeed.domain.entity.repository.Repository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RespositoryImpl(private val api: Api,
                      private val converter: Converter<Response, List<NewsEntity>>) : Repository {

    override fun getNews(page: Int): Single<List<NewsEntity>>  = api.getNews(page)
        .subscribeOn(Schedulers.io())
        .map(converter::convertTo)

}