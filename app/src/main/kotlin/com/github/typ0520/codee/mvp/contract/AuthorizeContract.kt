package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter

/**
 * Created by tong on 2017-12-21.
 */
interface AuthorizeContract {
    interface View : IBaseView {
        fun showError(errorMsg: String? = null)

        fun setAccessToken(accessToken: String)
    }

    interface Presenter : IPresenter<View> {
        fun getAccessToken(code: String)
    }
}
