package com.example.newsfeed.presentation.moxy.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.newsfeed.R

fun ImageView.loadGlideImgUrl(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)

fun ImageView.loadGlideImgId(resId: Int) =
    Glide.with(this)
        .load(resId)
        .into(this)