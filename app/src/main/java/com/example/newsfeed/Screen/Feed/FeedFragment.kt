package com.example.newsfeed.Screen.Feed

import android.os.Bundle
import android.view.View
import com.example.newsfeed.R
import com.example.newsfeed.common.BaseFragment

class FeedFragment : BaseFragment(R.layout.feed_fragment), FeedView {

    val API_KEY = "26eddb253e7840f988aec61f2ece2907"

    companion object {
        fun createInstance() = FeedFragment()
    }



}