package com.example.newsfeed.dagger

import com.example.newsfeed.data.data.converter.Converter
import com.example.newsfeed.data.data.converter.ConverterImpl
import com.example.newsfeed.data.data.converter.TwoWayConverter
import com.example.newsfeed.data.data.converter.TwoWayConverterImpl
import com.example.newsfeed.data.data.database.entity.NewsDbEntity
import com.example.newsfeed.data.data.response.Response
import com.example.newsfeed.domain.entity.entity.NewsEntity
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {
    @Reusable
    @Binds
    fun bindNewsConverter(instance: ConverterImpl): Converter<Response, List<NewsEntity>>

    @Reusable
    @Binds
    fun bindNewsTwoWayConverter(instance: TwoWayConverterImpl): TwoWayConverter<List<NewsEntity>, List<NewsDbEntity>>

}