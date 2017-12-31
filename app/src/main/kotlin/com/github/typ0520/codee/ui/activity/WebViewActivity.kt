package com.github.typ0520.codee.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.github.typ0520.codee.R
import kotlinx.android.synthetic.main.activity_webview.*
import com.github.typ0520.codee.base.BaseActivity
import android.net.http.SslError
import android.support.v7.widget.Toolbar
import android.webkit.*

/**
 * Created by tong on 2017/12/19.
 */
open class WebViewActivity : BaseActivity() {
    companion object {
        val EXTAR_URL = "url"
        val EXTAR_TITLE = "title"

        fun start(context: Context, url: String, title: String = "") {
            val intent = Intent(context, AuthorizeActivity::class.java)
            intent.putExtra(EXTAR_URL,url)
            intent.putExtra(EXTAR_TITLE,title)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        initWebView(webview)

        val url: String? = intent.getStringExtra(EXTAR_URL)
        url?.let {
            webview.loadUrl(url)
        }
    }

    override fun initToolbar(toolbar: Toolbar) {
        super.initToolbar(toolbar)

        val title: String? = intent.getStringExtra(EXTAR_TITLE)
        title?.let {
            toolbar.title = title
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    open fun initWebView(webview: WebView) {
        webview.settings.javaScriptEnabled = true
        webview.webViewClient = DefaultWebViewClient()
        webview.webChromeClient = DefaultWebChromeClient()
    }

    open class DefaultWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            Log.d(TAG,"shouldOverrideUrlLoading: $url?")
            return super.shouldOverrideUrlLoading(view, url)
        }

        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            handler.proceed()
        }
    }

    open class DefaultWebChromeClient : WebChromeClient()
}