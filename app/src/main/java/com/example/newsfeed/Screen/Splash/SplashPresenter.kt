package com.example.newsfeed.Screen.Splash

import com.example.newsfeed.common.BasePresenter
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit

class SplashPresenter(
    private val router: Router
) : BasePresenter<SplashView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Completable.timer(2,TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}