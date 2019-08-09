package com.example.newsfeed.dagger

import com.example.newsfeed.presentation.moxy.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun provideMainActivity(): MainActivity
}