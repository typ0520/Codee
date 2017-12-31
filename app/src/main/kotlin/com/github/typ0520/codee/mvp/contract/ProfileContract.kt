package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017-12-25.
 */
interface ProfileContract {
    interface View : IBaseView {
        fun setUserInfo(user: User)
        fun showError()
    }

    interface Presenter : IPresenter<View> {
        fun getUserInfo(username: String)
    }
}
