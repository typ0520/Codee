package com.github.typ0520.codee.base

import android.content.Context
import android.os.Handler
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import com.github.typ0520.codee.R
import com.bigkoo.svprogresshud.SVProgressHUD
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by tong on 2017/12/19.
 */
abstract class BaseActivity : RxAppCompatActivity(), IBaseView {
    companion object {
        val TAG: String = BaseActivity::class.java.simpleName
    }

    val progressHUD by lazy { SVProgressHUD(this) }

    val handler by lazy { Handler() }

    override fun setContentView(view: View?) {
        super.setContentView(view)

        onSetContentView()
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)

        onSetContentView()
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        super.setContentView(view, params)

        onSetContentView()
    }

    open fun onSetContentView() {
        val toolbar: Toolbar? = findViewById(R.id.toolbar)

        if (toolbar != null) {
            //setSupportActionBar(toolbar)
            initToolbar(toolbar)
        }
    }

    open fun initToolbar(toolbar: Toolbar) {
        if (toolbar.navigationIcon == null) {
            toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white)
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun showLoading(msg: String?) {
        if (msg == null) {
            progressHUD.show()
        }
        else {
            progressHUD.showWithStatus(msg)
        }
    }

    override fun dismissLoading() {
        progressHUD.dismiss()
    }

    fun getContext(): Context {
        return this
    }
}