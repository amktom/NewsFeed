package com.example.newsfeed.data.data.network

import com.example.newsfeed.data.data.response.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

@GET("https://newsapi.org/v2/everything?q=android&from=2019-04-00&sortBy=publi shedAt&apiKey=26eddb253e7840f988aec61f2ece2907&page=page")
fun getNews(@Query("page") page: Int): Single<Response>

}