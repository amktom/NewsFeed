package com.example.newsfeed.presentation.moxy.Screen.MainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.newsfeed.R
import com.example.newsfeed.presentation.moxy.moxy.MvpAppCompatActivity
import com.example.newsfeed.presentation.moxy.navigation.Navigator
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), HasSupportFragmentInjector, MainView {

    @Inject
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter


    @ProvidePresenter
    fun providePresenter(): MainPresenter = mainPresenter

    @Inject
    lateinit var supportFragmentInjectorImpl: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjectorImpl

    @Inject
    lateinit var navigattorHolder: NavigatorHolder

    private val navigator: SupportAppNavigator by lazy {
        Navigator(this, supportFragmentManager, R.id.container)
    }

    override fun onResume() {
        super.onResume()
        navigattorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigattorHolder.removeNavigator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
