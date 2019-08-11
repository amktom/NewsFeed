package com.example.newsfeed.presentation.moxy.screen.feed

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.newsfeed.R
import com.example.newsfeed.domain.entity.entity.NewsEntity
import com.example.newsfeed.presentation.moxy.common.BaseFragment
import com.example.newsfeed.presentation.moxy.common.showSnackbar
import com.example.newsfeed.presentation.moxy.screen.web.WebActivity
import kotlinx.android.synthetic.main.feed_fragment.*
import javax.inject.Inject

class FeedFragment : BaseFragment(R.layout.feed_fragment), FeedView {

    companion object {
        fun createInstance() = FeedFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var feedPresenter: FeedPresenter

    @ProvidePresenter
    fun providePresenter(): FeedPresenter = feedPresenter

    private val feedAdapter = Adapter {

        feedPresenter.loadNews()
    }

    override fun showFeed(news: List<NewsEntity>) {

        feedAdapter.setItems(news)

    }

    override fun showNetworkError() {
        recyclerView.showSnackbar("Network error")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFeed()
        initListner()
        feedPresenter.loadNews()

        refreshLayout.setOnRefreshListener(feedPresenter::refreshPosts)

    }

    private fun initFeed() {
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = feedAdapter
    }

    private fun initListner() {
        feedAdapter.addOnClickNews {
            val intent = WebActivity.instance(
                requireContext(),
                feedAdapter.getUrlFromPosition(it.adapterPosition)
            )
            startActivity(intent)
        }
        feedAdapter.addOnClickReload { feedPresenter.refreshPosts() }
    }

    override fun showProgress() {
        refreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        refreshLayout.isRefreshing = false
    }

    override fun showButton() {
        feedAdapter.showReloadButton()
    }
}