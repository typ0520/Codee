package com.github.typ0520.codee.base

import com.github.typ0520.codee.network.Github
import com.github.typ0520.codee.network.RetrofitManager

/**
 * Created by tong on 2017/12/20.
 */
open class BasePersenter<V : IBaseView> : IPresenter<V> {
    var view: V? = null
        private set

    protected val model: Github by lazy { RetrofitManager.repository }

    override fun attachView(view: IBaseView) {
        this.view = view as V
    }

    override fun detachView() {
        view = null
    }
}