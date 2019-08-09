package com.example.newsfeed.presentation.moxy.common

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import com.bumptech.glide.Glide
import com.example.newsfeed.R
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadGlideImgUrl(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)

fun ImageView.loadGlideImgId(resId: Int) =
    Glide.with(this)
        .load(resId)
        .into(this)

fun View.showSnackbar(
    string: String,
    @ColorInt colorId: Int = Color.WHITE,
    length: Int = Snackbar.LENGTH_LONG
) {
    val snack = Snackbar.make(this, string, length)
    val tv = snack.view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
    tv.setTextColor(colorId)
    snack.show()
}