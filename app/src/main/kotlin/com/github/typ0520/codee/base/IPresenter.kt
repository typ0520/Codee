package com.github.typ0520.codee.base

/**
 * Created by tong on 2017/12/20.
 */
interface IPresenter<out V: IBaseView> {
    fun attachView(view: IBaseView)

    fun detachView()
}
