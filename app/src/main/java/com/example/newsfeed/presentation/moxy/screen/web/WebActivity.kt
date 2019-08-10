package com.example.newsfeed.presentation.moxy.screen.web

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.newsfeed.R
import kotlinx.android.synthetic.main.web_activity.*
import kotlinx.android.synthetic.main.web_activity.view.*
import kotlinx.android.synthetic.main.web_activity.view.web_view

class WebActivity : AppCompatActivity() {

    companion object {

        fun instance(context: Context, url: String): Intent {
            val intent = Intent(context, WebActivity::class.java)
            intent.putExtra("URL", url)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        web_view.loadUrl(intent?.extras?.getString("URL"))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}