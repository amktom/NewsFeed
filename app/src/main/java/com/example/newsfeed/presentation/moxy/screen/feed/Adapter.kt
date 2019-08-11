package com.example.newsfeed.presentation.moxy.screen.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.R
import com.example.newsfeed.domain.entity.entity.NewsEntity
import com.example.newsfeed.presentation.moxy.common.loadGlideImgUrl
import kotlinx.android.synthetic.main.item.view.*

class Adapter(private val onLoadPost: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var onClickNews: (Holder) -> Unit
    private lateinit var onClickReload: (ReloadHolder) -> Unit
    private var news = mutableListOf<NewsEntity>()
    private var isReload = false

    companion object {
        const val NEWS = 1
        const val RELOAD = 2
    }

    override fun getItemViewType(position: Int): Int = if (position == news.size - 1 && isReload) RELOAD else NEWS

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {

        NEWS -> Holder.createIntance(parent)
        RELOAD -> ReloadHolder.createInstance(parent)

        else -> throw IllegalStateException("Illegal view holder type")
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (news.size - position < 5) {
            onLoadPost()
        }

        when (holder) {
            is Holder -> {
                holder.bind(news[position])
                initListner(holder)
            }

            is ReloadHolder -> initListner(holder)
        }
    }

    fun addOnClickNews(listner: (Holder) -> Unit) {
        onClickNews = listner
    }

    fun addOnClickReload(listner: (ReloadHolder) -> Unit) {
        onClickReload = listner
    }

    private fun initListner(holder: RecyclerView.ViewHolder) {
        when(holder) {
            is Holder -> {
                holder.addOnClickListner(onClickNews)
            }
            is ReloadHolder -> {
               holder.addOnClickListner(onClickReload)
            }
        }
    }

    fun getUrlFromPosition(position: Int): String = news[position].url

    fun setItems(listNews: List<NewsEntity>) {
        isReload = false
        news.addAll(listNews)
        notifyDataSetChanged()
    }

    fun showReloadButton() {
        isReload = true
        notifyDataSetChanged()
    }

}

class Holder(view: View) : RecyclerView.ViewHolder(view) {

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

class ReloadHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createInstance(parent: ViewGroup) = ReloadHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.reload_button,
                parent,
                false
            )
        )
    }

    fun addOnClickListner(listner: (ReloadHolder) -> Unit) {

        itemView.setOnClickListener { listner(this) }
    }
}