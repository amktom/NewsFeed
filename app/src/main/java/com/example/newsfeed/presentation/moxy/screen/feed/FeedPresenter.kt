package com.example.newsfeed.presentation.moxy.screen.feed

import com.example.newsfeed.domain.entity.entity.NewsEntity
import com.example.newsfeed.domain.entity.repository.Repository
import com.example.newsfeed.presentation.moxy.common.BasePresenter
import com.example.newsfeed.presentation.moxy.common.Paginator
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FeedPresenter @Inject constructor (private val repository: Repository): BasePresenter<FeedView>() {

    private val paginator = Paginator(
        {
            repository.getNews(it)
                .observeOn(AndroidSchedulers.mainThread())
        }, object : Paginator.ViewController<NewsEntity> {

            override fun showEmptyProgress(show: Boolean) {

            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {
            }

            override fun showEmptyView(show: Boolean) {
            }

            override fun showData(show: Boolean, data: List<NewsEntity>) {

                viewState.showFeed(data.map { NewsEntity(it.title, it.description, it.publishedAt, it.urlImg, it.url)})

            }

            override fun showErrorMessage(error: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun showRefreshProgress(show: Boolean) {

            }

            override fun showPageProgress(show: Boolean) {

            }
        })

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        paginator.refresh()
//        viewState.showFeed()
    }

    fun loadNews() {
        paginator.loadNewPage()
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }

}