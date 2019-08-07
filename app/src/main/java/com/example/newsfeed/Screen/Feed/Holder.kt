package com.example.newsfeed.Screen.Feed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.models.Article
import kotlinx.android.synthetic.main.item.view.*

class Holder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(article: Article) {
        itemView.title.text = article.title
        itemView.desc.text = article.description
        itemView.source.text = article.source.toString()
        itemView.author.text = article.author
        itemView.publishedAt.text = article.publishedAt
    }
}