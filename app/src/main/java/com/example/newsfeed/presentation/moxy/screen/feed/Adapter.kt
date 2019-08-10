package com.example.newsfeed.presentation.moxy.screen.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.R
import com.example.newsfeed.domain.entity.entity.NewsEntity
import com.example.newsfeed.presentation.moxy.common.loadGlideImgUrl
import kotlinx.android.synthetic.main.item.view.*

class Adapter (private val onLoadPost: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var onClickNews: (Holder) -> Unit
    private var news = mutableListOf<NewsEntity>()
    private var isRepeat = false

    companion object {
        const val NEWS = 1
        const val REPEAT = 2
    }

    override fun getItemViewType(position: Int): Int = if (position == news.size - 1 && isRepeat) REPEAT else NEWS

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {

        NEWS -> Holder.createIntance(parent)

        else -> throw IllegalStateException("Illegal view holder type")
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(news.size - position < 5) {
            onLoadPost()
        }

        when(holder) {
            is Holder -> {
                holder.bind(news[position])
            }
        }
    }

    fun addOnClickNews(listner: (Holder) -> Unit) {
        onClickNews = listner
    }

    private fun initListner(holder: Holder) {
        holder.addOnClickListner(onClickNews)
    }

    fun getUrlFromPosition(position: Int): String = news[position].url

    fun setItems(listNews: List<NewsEntity>) {
        news.addAll(listNews)
        notifyDataSetChanged()
    }


}

class Holder (view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createIntance(parent: ViewGroup) = Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }

    fun bind(news: NewsEntity) {
        itemView.title.text = news.title
        itemView.desc.text = news.description
        itemView.publishedAt.text = news.publishedAt
        news.urlImg?.let {
             itemView.img.loadGlideImgUrl(it)
        }
    }

    fun addOnClickListner(listner: (Holder) -> Unit) {

        itemView.setOnClickListener { listner(this) }
    }
}