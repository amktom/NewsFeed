package com.example.newsfeed.data.data.converter

import com.example.newsfeed.data.data.database.entity.NewsDbEntity
import com.example.newsfeed.domain.entity.entity.NewsEntity
import javax.inject.Inject

class TwoWayConverterImpl @Inject constructor() : TwoWayConverter<@kotlin.jvm.JvmSuppressWildcards List<NewsEntity>,
        @kotlin.jvm.JvmSuppressWildcards List<NewsDbEntity>> {

    override fun convertTo(t: List<NewsEntity>): List<NewsDbEntity> =
            t.map { NewsDbEntity(it.title, it.description, it.urlImg, it.publishedAt, it.url) }

    override fun convertFrom(k: List<NewsDbEntity>): List<NewsEntity> =
            k.map { NewsEntity(it.title, it.descr, it.urlImage, it.publishedAt ,it.url) }

}