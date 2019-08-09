package com.example.newsfeed.presentation.moxy.screen.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.newsfeed.R
import com.example.newsfeed.presentation.moxy.common.BaseFragment
import javax.inject.Inject

class SplashFragment : BaseFragment(R.layout.splash_fragment), SplashView {

    companion object {
        fun createInstance() = SplashFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var splashPresenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = splashPresenter

}