package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter
import com.github.typ0520.codee.mvp.bean.EventList

/**
 * Created by tong on 2017/12/20.
 */
interface EventsContract {
    interface View : IBaseView {
        fun setData(events: EventList, loadMore: Boolean)

        fun showError(loadMode: Boolean)
    }

    interface Presenter : IPresenter<View> {
        fun getData()
        fun loadMore()
    }
}