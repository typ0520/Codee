package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter
import com.github.typ0520.codee.mvp.bean.Repository

/**
 * Created by tong on 2017-12-29.
 */
interface TrendingContract {
    interface View : IBaseView {
        fun setData(triple: Triple<List<Repository>, List<Repository>, List<Repository>>)
        fun showError()
    }

    interface Presenter : IPresenter<View> {
        fun getData(language: String)
    }
}
