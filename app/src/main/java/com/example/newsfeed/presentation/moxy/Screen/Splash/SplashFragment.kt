package com.example.newsfeed.presentation.moxy.Screen.Splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.newsfeed.R
import com.example.newsfeed.presentation.moxy.common.BaseFragment

class SplashFragment : BaseFragment(R.layout.splash_fragment), SplashView {

    companion object {
        fun createInstance() = SplashFragment()
    }

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = presenter

}