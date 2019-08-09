package com.example.newsfeed.presentation.moxy.Screen.MainActivity

import com.example.newsfeed.presentation.moxy.common.BasePresenter
import com.example.newsfeed.presentation.moxy.navigation.Screen
import ru.terrakok.cicerone.Router

class MainPresenter (private val router: Router) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screen.SplashScreen())
    }
}