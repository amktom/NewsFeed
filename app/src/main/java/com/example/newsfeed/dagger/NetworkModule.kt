package com.example.newsfeed.dagger

import com.example.newsfeed.data.data.network.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://newsapi.org/v2/")
        .build()

    @Singleton
    @Provides
    fun providerApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
}