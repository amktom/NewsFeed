package com.example.newsfeed.data.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "news")
data class NewsDbEntity(

    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "descr") val descr: String,
    @ColumnInfo(name = "urlImage") val urlImage: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "publishedAt") val publishedAt: String

)