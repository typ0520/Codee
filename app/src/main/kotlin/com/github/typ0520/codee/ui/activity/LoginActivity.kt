package com.github.typ0520.codee.ui.activity

import android.content.Intent
import android.os.Bundle
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpActivity
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.LoginContract
import com.github.typ0520.codee.mvp.presenter.LoginPresenter
import com.github.typ0520.codee.utils.show
import com.bumptech.glide.Glide
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_login.*
import com.bumptech.glide.request.RequestOptions
import com.elvishew.xlog.XLog

/**
 * Created by tong on 2017-12-22.
 */
class LoginActivity : BaseMvpActivity<LoginContract.View,LoginContract.Presenter>(), LoginContract.View {
    override fun createPresenter() = LoginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user: User? = User.current()
        val accessToken = user?.access_token ?: Hawk.get("access_token")

        XLog.d("accessToken: $accessToken")
        if (user != null) {
            Glide.with(this)
                    .load(user.avatar_url)
                    .apply(RequestOptions().placeholder(R.drawable.login_user_unknown).circleCrop())
                    .into(iv)
            tv_message.show()
            tv_message.text = "Logging in ${user.login}"
        }
        presenter.getUserInfo(accessToken)
    }

    override fun setUser(it: User) {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun showError() {
        //TODO handle error
    }
}

