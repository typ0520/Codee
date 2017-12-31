package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017-12-22.
 */
interface LoginContract {
    interface View : IBaseView {
        fun setUser(it: User)

        fun showError()
    }

    interface Presenter : IPresenter<View> {
        fun getUserInfo(accessToken: String)
    }
}
