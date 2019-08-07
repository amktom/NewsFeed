package com.example.newsfeed.Screen.Feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.R
import com.example.newsfeed.models.Article

class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun getItemCount(): Int =
        items.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
         is Holder -> holder.bind(items[position])
        }
    }

    fun setNews(news: List<Article>) {
        items.addAll(news)
    }

}