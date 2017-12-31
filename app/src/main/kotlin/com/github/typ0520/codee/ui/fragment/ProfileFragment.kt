package com.github.typ0520.codee.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpFragment
import com.github.typ0520.codee.base.EXTRA_USERNAME
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.ProfileContract
import com.github.typ0520.codee.mvp.presenter.ProfilePresenter
import com.github.typ0520.codee.ui.activity.EventsActivity
import com.github.typ0520.codee.ui.activity.MainActivity
import com.github.typ0520.codee.ui.activity.RepositoriesActivity
import com.github.typ0520.codee.ui.activity.UsersActivity
import com.github.typ0520.codee.utils.showLongToast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zhy.fabridge.lib.Fabridge
import kotlinx.android.synthetic.main.fragment_profile.*
import com.github.typ0520.codee.utils.showSomethingIsWrongError

/**
 * Created by tong on 2017-12-25.
 */
class ProfileFragment : BaseMvpFragment<ProfileContract.View, ProfilePresenter>(), ProfileContract.View, View.OnClickListener {
    companion object {
        fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()
            return fragment
        }

        fun newInstance(username: String): ProfileFragment {
            val bundle = Bundle()
            bundle.putString(EXTRA_USERNAME,username)

            val fragment = ProfileFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_profile

    override fun createPresenter() = ProfilePresenter()

    private var username: String? = null
    private var user: User? = null
    private var isCurrentUser = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        username = if (arguments != null) arguments.getString(EXTRA_USERNAME) else null
        isCurrentUser = TextUtils.isEmpty(username)
        user = if (isCurrentUser) User.current() else null
    }

    override fun initView() {
        toolbar.setNavigationOnClickListener {
            Fabridge.call(mActivity, MainActivity.EVENT_SHOW_OR_HIDE_DRAWER)
        }

        refresh_layout.setOnRefreshListener {
            if (username != null) {
                presenter.getUserInfo(username!!)
            }
            else {
                refresh_layout.finishRefresh(false)
            }
        }
    }

    override fun loadData() {
        val showCurrentUser = TextUtils.isEmpty(username)
        if (showCurrentUser && user == null) {
            //error status
            refresh_layout.isEnableRefresh = false
            showError()
            return
        }
        if (user == null) {
            showLoading()
            presenter.getUserInfo(username!!)
        }
        else {
            setUserInfo(user!!)
            displayUser(user!!)
        }
    }

    private fun displayUser(user: User) {
        username = user.login
        Glide.with(this)
                .load(user.avatar_url)
                .apply(RequestOptions().placeholder(R.drawable.avatar))
                .into(iv_avatar)

        tv_login.text = user.login
        tv_name.text = user.name
        tv_followers.text = user.followers.toString()
        tv_following.text = user.following.toString()

        ll_followers.setOnClickListener(this)
        ll_following.setOnClickListener(this)
        rl_events.setOnClickListener(this)
        rl_orgs.setOnClickListener(this)
        rl_repositories.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ll_followers       ->  UsersActivity.startFollowers(mActivity!!, username!!)
            R.id.ll_following       ->  UsersActivity.startFollowing(mActivity!!, username!!)
            R.id.rl_events          ->  EventsActivity.startEvents(mActivity!!, username!!)
            R.id.rl_orgs            ->  showLongToast("TODO")
            R.id.rl_repositories    ->  RepositoriesActivity.startOwend(mActivity!!, username!!)
        }
    }

    override fun setUserInfo(user: User) {
        dismissLoading()
        refresh_layout.finishRefresh()
        displayUser(user)
    }

    override fun showError() {
        progressHUD.dismissImmediately()
        progressHUD.showSomethingIsWrongError()
        refresh_layout.finishRefresh(false)
    }
}
