package com.example.newsfeed.dagger

import com.example.newsfeed.presentation.moxy.screen.feed.FeedFragment
import com.example.newsfeed.presentation.moxy.screen.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideFeedFragment(): FeedFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashFragment(): SplashFragment
}