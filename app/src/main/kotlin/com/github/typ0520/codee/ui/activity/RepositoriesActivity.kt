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
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.contract.RepositoriesContract
import com.github.typ0520.codee.mvp.presenter.RepositoriesPresenter
import com.github.typ0520.codee.ui.adapter.RepositoryAdapter
import com.github.typ0520.codee.ui.widget.SimpleViewHolder
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import kotlinx.android.synthetic.main.activity_repositories.*

/**
 * Created by tong on 2017-12-29.
 */
class RepositoriesActivity : BaseMvpActivity<RepositoriesContract.View,RepositoriesContract.Presenter>(), RepositoriesContract.View {
    companion object {
        val EXTRA_MODEL_TYPE = "model_type"
        val EXTRA_OWNER_NAME = "owner_name"
        val EXTRA_REPO_NAME = "repo_name"

        val MODEL_TYPE_FORKS = "Forks"
        val MODEL_TYPE_OWNED = "Repositories"
        val MODEL_TYPE_STARRED = "Starred"

        fun startForks(context: Context, ownerName: String, repoName: String) = start(context,MODEL_TYPE_FORKS , ownerName, repoName)

        fun startOwend(context: Context, ownerName: String) = start(context, MODEL_TYPE_OWNED, ownerName)

        fun startStarred(context: Context, ownerName: String) = start(context, MODEL_TYPE_STARRED, ownerName)

        private fun start(context: Context,modelType: String, ownerName: String, repoName: String = "") {
            val intent = Intent(context, RepositoriesActivity::class.java)
            intent.putExtra(EXTRA_MODEL_TYPE,modelType)
            intent.putExtra(EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EXTRA_REPO_NAME,repoName)

            context.startActivity(intent)
        }
    }

    override fun createPresenter() = RepositoriesPresenter(modelType!!, ownerName!!, repoName)

    private val adapter = FilterOwnerRepositoryAdapter()
    private var loadService: LoadService<Any>? = null

    private var modelType: String? = null
    private var ownerName: String? = null
    private var repoName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        modelType = intent.getStringExtra(EXTRA_MODEL_TYPE)
        ownerName = intent.getStringExtra(EXTRA_OWNER_NAME)
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
        if (TextUtils.isEmpty(ownerName)) {
            throw IllegalArgumentException("Username con not be null or empty!!")
        }
        if (modelType.equals(MODEL_TYPE_FORKS) && TextUtils.isEmpty(repoName)) {
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

    override fun setData(repositories: List<Repository>, loadMore: Boolean) {
        if (loadMore) {
            if (repositories.size < DEFAULT_PER_PAGE) {
                //disable load more
                refresh_layout.finishLoadmoreWithNoMoreData()
            }
            if (!repositories.isEmpty()) {
                refresh_layout.finishLoadmore()
                adapter.loadmore(repositories)
            }
        }
        else {
            refresh_layout.finishRefresh()
            if (repositories.isEmpty()) {
                //display no-data view
                loadService?.showCallback(EmptyCallback::class.java)
            }
            else {
                if (repositories.size < DEFAULT_PER_PAGE) {
                    refresh_layout.finishLoadmoreWithNoMoreData()
                }
                else {
                    refresh_layout.resetNoMoreData()
                }
                loadService?.showSuccess()
            }
            adapter.refresh(repositories)
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

    inner class FilterOwnerRepositoryAdapter: RepositoryAdapter(this) {
        override fun onBindViewHolder(holder: SimpleViewHolder, model: Repository?, position: Int) {
            super.onBindViewHolder(holder, model, position)
            holder.hide(R.id.ll_owner,{ RepositoriesActivity.MODEL_TYPE_OWNED == modelType })
        }
    }
}

