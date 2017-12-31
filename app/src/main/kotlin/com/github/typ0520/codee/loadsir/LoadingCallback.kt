package com.github.typ0520.codee.loadsir

import android.content.Context
import android.view.View
import com.github.typ0520.codee.R
import com.kingja.loadsir.callback.Callback

/**
 * Created by tong on 2017/12/25.
 */
class LoadingCallback : Callback() {
    override fun onCreateView(): Int {
        return R.layout.layout_loading
    }

    override fun getSuccessVisible(): Boolean {
        return super.getSuccessVisible()
    }

    override fun onReloadEvent(context: Context?, view: View?): Boolean {
        return true
    }
}