package com.example.newsfeed.data.data.converter

interface Converter<T, K> {

    fun convertTo(t: T): K

}