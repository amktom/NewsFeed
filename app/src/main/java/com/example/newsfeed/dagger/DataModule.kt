package com.example.newsfeed.dagger

import com.example.newsfeed.data.data.converter.Converter
import com.example.newsfeed.data.data.network.Api
import com.example.newsfeed.data.data.repository.RespositoryImpl
import com.example.newsfeed.data.data.response.Response
import com.example.newsfeed.domain.entity.entity.NewsEntity
import com.example.newsfeed.domain.entity.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
        NetworkModule::class,
        ConverterModule::class
])


class DataModule {

    @Provides
    @Singleton
    fun bindFeedRepository(api: Api, converter: Converter<Response, List<NewsEntity>>): Repository =
        RespositoryImpl(api, converter)
}