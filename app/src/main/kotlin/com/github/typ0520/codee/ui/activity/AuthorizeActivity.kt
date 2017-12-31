package com.github.typ0520.codee.ui.activity

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_webview.*
import android.support.v7.widget.Toolbar
import android.webkit.*
import com.github.typ0520.codee.BuildConfig
import com.github.typ0520.codee.mvp.contract.AuthorizeContract
import com.github.typ0520.codee.mvp.presenter.AuthorizePresenter
import com.github.typ0520.codee.network.Github
import com.github.typ0520.codee.utils.parseQueryString
import com.elvishew.xlog.XLog
import java.net.URI

/**
 * Created by tong on 2017/12/19.
 */
class AuthorizeActivity : WebViewActivity(), AuthorizeContract.View {
    val presenter: AuthorizePresenter by lazy {
        val p = AuthorizePresenter()
        p.attachView(this)
        return@lazy p
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = "${Github.BASE_URL_GITHUB}login/oauth/authorize?client_id=${BuildConfig.CLIENT_ID}"
        XLog.d(url)
        webview.loadUrl(url)
    }

    override fun initToolbar(toolbar: Toolbar) {
        super.initToolbar(toolbar)

        toolbar.title = "Login"
    }

    override fun initWebView(webview: WebView) {
        super.initWebView(webview)

        webview.webViewClient = object : DefaultWebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url!!.startsWith("dp://callback")) {
                    val map = URI(url).query.parseQueryString()
                    val code = map.get("code")!!
                    XLog.d("code: $code")

                    showLoading("Logging in...")
                    presenter.getAccessToken(code)
                    return true
                }
                return super.shouldOverrideUrlLoading(view, url)
            }
        }
    }

    override fun setAccessToken(accessToken: String) {
        dismissLoading()
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    override fun showError(errorMsg: String?) {
        progressHUD.dismissImmediately()
        if (errorMsg == null) {
            progressHUD.showErrorWithStatus("Login fail")
        }
        else {
            progressHUD.showErrorWithStatus(errorMsg)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }
}