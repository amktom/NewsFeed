package com.example.newsfeed.data.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.newsfeed.data.data.database.entity.NewsDbEntity
import io.reactivex.Single


@Dao
interface Dao {

    @Query("SELECT * from news")
    fun getAll() : Single<List<NewsDbEntity>>

    @Query("SELECT * from news WHERE id=:newsID")
    fun getNewsById(newsID: String): NewsDbEntity?

    @Insert
    fun insert(news: NewsDbEntity): Long
}