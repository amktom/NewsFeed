package com.example.newsfeed.dagger

import com.example.newsfeed.presentation.moxy.screen.Feed.FeedFragment
import com.example.newsfeed.presentation.moxy.screen.Splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideFeedFragment(): FeedFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplasgFragment(): SplashFragment
}