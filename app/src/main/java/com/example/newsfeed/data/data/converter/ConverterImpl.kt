package com.example.newsfeed.data.data.converter

import com.example.newsfeed.data.data.models.News
import com.example.newsfeed.data.data.response.Response
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ConverterImpl : Converter<Response, List<News>> {

    override fun convertTo(t: Response): List<News> = t.response.map {
        News(
            it.title,
            it.desription,
            it.url,
            it.urlToImage,
            it.publishedAt
        )
    }

    private fun convertDate(date: Date): String =
        SimpleDateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault()).format(date)
}