package com.github.typ0520.codee.mvp.contract

import com.github.typ0520.codee.base.IBaseView
import com.github.typ0520.codee.base.IPresenter
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.bean.User

/**
 * Created by tong on 2017-12-30.
 */
interface SearchContract {
    interface View : IBaseView {
        fun setRepositories(repositories: List<Repository>)
        fun setUsers(users: List<User>)
        fun showError()
    }

    interface Presenter : IPresenter<View> {
        fun searchRepositories(query: String)
        fun searchUsers(query: String)
    }
}
