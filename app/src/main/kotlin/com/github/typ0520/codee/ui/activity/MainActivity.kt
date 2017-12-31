package com.github.typ0520.codee.ui.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseActivity
import com.github.typ0520.codee.base.BaseFragment
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.ui.fragment.EventsFragment
import com.github.typ0520.codee.ui.fragment.ProfileFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*
import com.zhy.fabridge.annotation.FCallbackId
import android.content.Intent
import com.github.typ0520.codee.ui.fragment.SearchFragment
import com.github.typ0520.codee.ui.fragment.TrendingFragment
import com.github.typ0520.codee.utils.showLongToast

/**
 * Created by tong on 2017/12/19.
 */
class MainActivity : BaseActivity() {
    companion object {
        const val EVENT_SHOW_OR_HIDE_DRAWER = "EVENT_SHOW_OR_HIDE_DRAWER"
    }

    private val iv_avatar by lazy { nv_menu.getHeaderView(0).findViewById(R.id.iv_avatar) as ImageView }
    private val tv_login by lazy { nv_menu.getHeaderView(0).findViewById(R.id.tv_login) as TextView }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START)
        }
        val username = User.current()!!.login

        when(item.itemId) {
            R.id.group_item_profile     ->  replaceFragment(ProfileFragment.newInstance(username))
            R.id.group_item_notis       ->  showLongToast("TODO")
            R.id.group_item_news        ->  replaceFragment(EventsFragment.newInstanceForNews(username))
            R.id.group_item_events      ->  EventsActivity.startEvents(this, username)
            R.id.group_item_owned       ->  RepositoriesActivity.startOwend(this, username)
            R.id.group_item_starred     ->  RepositoriesActivity.startStarred(this, username)
            R.id.group_item_trending    ->  replaceFragment(TrendingFragment.newInstance())
            R.id.group_item_search      ->  replaceFragment(SearchFragment.newInstance())
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nv_menu.setNavigationItemSelectedListener(::onNavigationItemSelected)
        val user: User = User.current()!!
        Glide.with(this)
                .load(user.avatar_url)
                .apply(RequestOptions().placeholder(R.drawable.login_user_unknown).circleCrop())
                .into(iv_avatar)
        tv_login.text = user.login

        if (savedInstanceState == null) {
            replaceFragment(EventsFragment.newInstanceForNews(user.login))
        }
    }

    private fun replaceFragment(fragment: BaseFragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container,fragment)
                .commit()
    }

    @FCallbackId(id = EVENT_SHOW_OR_HIDE_DRAWER)
    fun showOrHideDrawer() {
        if (!dl.isDrawerOpen(GravityCompat.START)) {
            dl.openDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START)
        } else {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.addCategory(Intent.CATEGORY_HOME)
            startActivity(intent)
        }
    }
}
