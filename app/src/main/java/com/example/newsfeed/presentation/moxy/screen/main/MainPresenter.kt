package com.example.newsfeed.presentation.moxy.screen.main

import com.example.newsfeed.presentation.moxy.common.BasePresenter
import com.example.newsfeed.presentation.moxy.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor (private val router: Router) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
//        router.newRootScreen(Screen.SplashScreen())
        router.newRootScreen(Screen.FeedScreen())
    }
}