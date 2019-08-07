package com.example.newsfeed.Screen.Splash

import com.example.newsfeed.R
import com.example.newsfeed.common.BaseFragment

class SplashFragment : BaseFragment(R.layout.splash_fragment), SplashView {

    companion object {
        fun createInstance() = SplashFragment()
    }

    lateinit var presenter: SplashPresenter

    fun providePresenter(): SplashPresenter = presenter

}