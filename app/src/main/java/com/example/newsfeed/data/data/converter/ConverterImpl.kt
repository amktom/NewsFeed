package com.example.newsfeed.data.data.converter

import com.example.newsfeed.data.data.models.News
import com.example.newsfeed.data.data.response.Response
import com.example.newsfeed.domain.entity.entity.NewsEntity
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class ConverterImpl @Inject constructor(): Converter<Response, @JvmSuppressWildcards List<NewsEntity>> {

    override fun convertTo(t: Response): List<NewsEntity> = t.response.map {
        NewsEntity(
            it.title,
            it.desription,
            it.url,
            it.urlToImage,
            convertDate(it.publishedAt)
        )
    }

    private fun convertDate(date: Date): String =
        SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault()).format(date)
}