package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter
import com.github.typ0520.codee.mvp.bean.Issue

/**
 * Created by tong on 2017-12-30.
 */
interface IssuesContract {
    interface View : IBaseView {
        fun setData(issues: List<Issue>, loadMore: Boolean)
        fun showError(loadMode: Boolean)
    }

    interface Presenter : IPresenter<View> {
        fun getData(state: String, creator: String?)
        fun loadMore(state: String, creator: String?)
    }
}
