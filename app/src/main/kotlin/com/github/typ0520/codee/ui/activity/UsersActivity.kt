package com.github.typ0520.codee.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpActivity
import com.github.typ0520.codee.base.DEFAULT_PER_PAGE
import com.github.typ0520.codee.loadsir.EmptyCallback
import com.github.typ0520.codee.loadsir.ErrorCallback
import com.github.typ0520.codee.loadsir.LoadingCallback
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.UsersContract
import com.github.typ0520.codee.mvp.presenter.UsersPresenter
import com.github.typ0520.codee.ui.adapter.UserAdapter
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.activity_users.*

/**
 * Created by tong on 2017-12-29.
 */
class UsersActivity : BaseMvpActivity<UsersContract.View, UsersContract.Presenter>(), UsersContract.View {
    companion object {
        val EXTRA_MODEL_TYPE = "model_type"
        val EXTRA_OWNER_NAME = "ownerName"
        val EXTRA_REPO_NAME = "repo_name"

        val MODEL_TYPE_FOLLOWERS = "Followers"
        val MODEL_TYPE_FOLLOWING = "Following"
        val MODEL_TYPE_STARGAZERS = "Stargazers"
        val MODEL_TYPE_WATCHERS = "Watchers"

        fun startFollowers(context: Context, username: String) = start(context, MODEL_TYPE_FOLLOWERS, username)

        fun startFollowing(context: Context, username: String) = start(context, MODEL_TYPE_FOLLOWING, username)

        fun startStargazers(context: Context, ownerName: String, repoName: String) = start(context, MODEL_TYPE_STARGAZERS, ownerName, repoName)

        fun startWatchers(context: Context, ownerName: String, repoName: String) = start(context, MODEL_TYPE_WATCHERS, ownerName, repoName)

        private fun start(context: Context,modelType: String, ownerName: String, repoName: String = "") {
            val intent = Intent(context, UsersActivity::class.java)
            intent.putExtra(EXTRA_MODEL_TYPE,modelType)
            intent.putExtra(EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EXTRA_REPO_NAME,repoName)

            context.startActivity(intent)
        }
    }

    override fun createPresenter() = UsersPresenter(modelType!!,username!!,repoName)

    private val adapter = UserAdapter(this)

    private var loadService: LoadService<Any>? = null

    private var modelType: String? = null
    private var username: String? = null
    private var repoName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        modelType = intent.getStringExtra(EXTRA_MODEL_TYPE)
        username = intent.getStringExtra(EXTRA_OWNER_NAME)
        repoName = intent.getStringExtra(EXTRA_REPO_NAME)
        checkArguments()

        toolbar.title = modelType!!
        initView()
        loadData()
    }

    private fun checkArguments() {
        if (TextUtils.isEmpty(modelType)) {
            throw IllegalArgumentException("modelType con not be null or empty!!")
        }
        if (TextUtils.isEmpty(username)) {
            throw IllegalArgumentException("Username con not be null or empty!!")
        }
        val repoNameRequired = modelType.equals(MODEL_TYPE_STARGAZERS) || modelType.equals(MODEL_TYPE_WATCHERS)
        if (repoNameRequired && TextUtils.isEmpty(repoName)) {
            throw IllegalArgumentException("Repository name con not be null or empty!!")
        }
    }

    private fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_view.adapter = adapter
        refresh_layout.setOnRefreshListener { loadData() }
        refresh_layout.setOnLoadmoreListener { presenter.loadMore() }

        //display loading
        loadService = LoadSir.getDefault().register(refresh_layout,{
            loadService?.showCallback(LoadingCallback::class.java)
            loadData()
        })
        loadService?.showCallback(LoadingCallback::class.java)
    }

    fun loadData() {
        presenter.getData()
    }

    override fun setData(followers: List<User>, loadMore: Boolean) {
        if (loadMore) {
            if (followers.size < DEFAULT_PER_PAGE) {
                //disable load more
                refresh_layout.finishLoadmoreWithNoMoreData()
            }
            if (!followers.isEmpty()) {
                refresh_layout.finishLoadmore()
                adapter.loadmore(followers)
            }
        }
        else {
            refresh_layout.finishRefresh()
            if (followers.isEmpty()) {
                //display no-data view
                loadService?.showCallback(EmptyCallback::class.java)
            }
            else {
                if (followers.size < DEFAULT_PER_PAGE) {
                    refresh_layout.finishLoadmoreWithNoMoreData()
                }
                else {
                    refresh_layout.resetNoMoreData()
                }
                loadService?.showSuccess()
            }
            adapter.refresh(followers)
        }
    }

    override fun showError(loadMode: Boolean) {
        if (loadMode) {
            refresh_layout.finishLoadmore(false)
        }
        else {
            loadService?.showCallback(ErrorCallback::class.java)
        }
    }
}

