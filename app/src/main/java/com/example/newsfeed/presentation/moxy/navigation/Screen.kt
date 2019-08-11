package com.example.newsfeed.presentation.moxy.navigation

import androidx.fragment.app.Fragment
import com.example.newsfeed.presentation.moxy.screen.feed.FeedFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment): BaseScreen(fragment){
    class FeedScreen : Screen(FeedFragment.createInstance())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}