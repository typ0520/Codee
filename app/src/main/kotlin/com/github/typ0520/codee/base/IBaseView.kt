package com.github.typ0520.codee.base

import android.arch.lifecycle.LifecycleOwner

/**
 * Created by tong on 2017/12/20.
 */
interface IBaseView : LifecycleOwner {
    fun showLoading(msg: String? = null)

    fun dismissLoading()
}