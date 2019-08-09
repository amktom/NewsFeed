package com.example.newsfeed.presentation.moxy.screen.Feed

import com.arellomobile.mvp.MvpView
import com.example.newsfeed.domain.entity.entity.NewsEntity

interface FeedView : MvpView {

    fun showFeed(news: List<NewsEntity>)

}