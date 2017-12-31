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
import com.github.typ0520.codee.mvp.bean.Issue
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.IssuesContract
import com.github.typ0520.codee.mvp.presenter.IssuesPresenter
import com.github.typ0520.codee.ui.widget.adapter1
import com.github.typ0520.codee.ui.widget.setOnItemClickListener
import com.github.typ0520.codee.utils.formatCreatedAt
import com.github.typ0520.codee.utils.showLongToast
import com.kingja.loadsir.callback.Callback
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.activity_issues.*

/**
 * Created by tong on 2017-12-30.
 */
class IssuesActivity : BaseMvpActivity<IssuesContract.View,IssuesContract.Presenter>(), IssuesContract.View {
    companion object {
        val EXTRA_OWNER_NAME = "owner_name"
        val EXTRA_REPO_NAME = "repo_name"

        private val STATE_ALL = "all"
        private val STATE_OPEN = "open"
        private val STATE_CLOSED = "closed"

        fun start(context: Context, ownerName: String, repoName: String) {
            val intent = Intent(context, IssuesActivity::class.java)
            intent.putExtra(EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EXTRA_REPO_NAME,repoName)

            context.startActivity(intent)
        }
    }

    override fun createPresenter() = IssuesPresenter(ownerName!!, repoName!!)

    private val adapter = adapter1<Issue>(R.layout.list_item_issue,{holder, model, position ->
        run {
            holder.text(R.id.tv_id,"#${model!!.number}")
            if (model.pull_request == null) {
                holder.text(R.id.tv_type, "Issue")
            }
            else {
                holder.text(R.id.tv_type, "Pull")
            }
            holder.text(R.id.tv_title, model.title)
            holder.text(R.id.tv_state, model.state)
            holder.text(R.id.tv_comment_count,"${model.comments}")
            if (model.assignee == null) {
                holder.text(R.id.tv_assignee, "unassigned")
            }
            else {
                holder.text(R.id.tv_assignee, model.assignee.login)
            }
            holder.text(R.id.tv_date,model.created_at.formatCreatedAt())
        }
    }).setOnItemClickListener { position, model -> showLongToast("TODO") }

    private var loadService: LoadService<Any>? = null

    private var ownerName: String? = null
    private var repoName: String? = null

    private var state = STATE_OPEN
    private var creator: String? = null

    private var lastCheckedId = R.id.btn_open
    private lateinit var lastCallback: Class<out Callback>

    private val currentUser = User.current()!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issues)

        ownerName = intent.getStringExtra(EXTRA_OWNER_NAME)
        repoName = intent.getStringExtra(EXTRA_REPO_NAME)
        checkArguments()

        initView()
        loadData()
    }

    private fun checkArguments() {
        if (TextUtils.isEmpty(ownerName)) {
            throw IllegalArgumentException("Username con not be null or empty!!")
        }
        if (TextUtils.isEmpty(repoName)) {
            throw IllegalArgumentException("Repository name con not be null or empty!!")
        }
    }

    private fun initView() {
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recycler_view.adapter = adapter
        refresh_layout.setOnRefreshListener {
            btn_open.isEnabled = false
            btn_closed.isEnabled = false
            btn_mine.isEnabled = false
            loadData()
        }
        refresh_layout.setOnLoadmoreListener { presenter.loadMore(state, creator) }

        //display loading
        loadService = LoadSir.getDefault().register(refresh_layout,{
            showLoadSirCallback(LoadingCallback::class.java)
            loadData()
        })

        showLoadSirCallback(LoadingCallback::class.java)

        sg.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != lastCheckedId) {
                when (checkedId) {
                    R.id.btn_open -> {
                        state = STATE_OPEN
                        creator = null
                    }
                    R.id.btn_closed -> {
                        state = STATE_CLOSED
                        creator = null
                    }
                    R.id.btn_mine -> {
                        state = STATE_OPEN
                        creator = currentUser.login
                    }
                }

                if (lastCallback == EmptyCallback::class.java) {
                    showLoadSirCallback(LoadingCallback::class.java)
                    loadData()
                }
                else {
                    refresh_layout.autoRefresh()
                }
            }
            lastCheckedId = checkedId
        }

        sg.isEnabled = false
    }

    fun loadData() {
        presenter.getData(state, creator)
    }

    fun showLoadSirCallback(callback: Class<out Callback>) {
        loadService?.showCallback(callback)
        lastCallback = callback
    }

    override fun setData(issues: List<Issue>, loadMore: Boolean) {
        if (loadMore) {
            if (issues.size < DEFAULT_PER_PAGE) {
                //disable load more
                refresh_layout.finishLoadmoreWithNoMoreData()
            }
            if (!issues.isEmpty()) {
                refresh_layout.finishLoadmore()
                adapter.loadmore(issues)
            }
        }
        else {
            refresh_layout.finishRefresh()
            if (issues.isEmpty()) {
                //display no-data view
                showLoadSirCallback(EmptyCallback::class.java)
            }
            else {
                if (issues.size < DEFAULT_PER_PAGE) {
                    refresh_layout.finishLoadmoreWithNoMoreData()
                }
                else {
                    refresh_layout.resetNoMoreData()
                }
                showLoadSirCallback(SuccessCallback::class.java)
            }
            adapter.refresh(issues)
        }

        btn_open.isEnabled = true
        btn_closed.isEnabled = true
        btn_mine.isEnabled = true
    }

    override fun showError(loadMode: Boolean) {
        if (loadMode) {
            refresh_layout.finishLoadmore(false)
        }
        else {
            showLoadSirCallback(ErrorCallback::class.java)
        }

        btn_open.isEnabled = true
        btn_closed.isEnabled = true
        btn_mine.isEnabled = true
    }
}
