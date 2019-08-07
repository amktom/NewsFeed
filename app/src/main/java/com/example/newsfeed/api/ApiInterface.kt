package com.example.newsfeed.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

@GET("everything")
fun getNews(@Query("q") q: String,
            @Query("apiKey") apiKey: String)
}