package com.github.typ0520.codee.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.format.Formatter
import android.view.View
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpActivity
import com.github.typ0520.codee.base.EXTRA_USERNAME
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.contract.RepositoryContract
import com.github.typ0520.codee.mvp.presenter.RepositoryPresenter
import com.github.typ0520.codee.utils.showLongToast
import com.github.typ0520.codee.utils.showSomethingIsWrongError
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elvishew.xlog.XLog
import kotlinx.android.synthetic.main.activity_repository.*

/**
 * Created by tong on 2017-12-28.
 */
class RepositoryActivity : BaseMvpActivity<RepositoryContract.View,RepositoryContract.Presenter>(), RepositoryContract.View, View.OnClickListener {
    companion object {
        val EXTRA_OWNER_NAME = "owner_name"
        val EXTRA_REPO_NAME = "repo_name"

        fun start(context: Context, ownerName: String, repoName: String) {
            val intent = Intent(context, RepositoryActivity::class.java)
            intent.putExtra(EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EXTRA_REPO_NAME,repoName)
            context.startActivity(intent)
        }

        fun start(context: Context, fullName: String) {
            val intent = Intent(context, RepositoryActivity::class.java)
            intent.putExtra(EXTRA_OWNER_NAME, fullName.split("/")[0])
            intent.putExtra(EXTRA_REPO_NAME, fullName.split("/")[1])
            context.startActivity(intent)
        }
    }

    override fun createPresenter() = RepositoryPresenter()

    private var ownerName: String? = null
    private var repoName: String? = null

    private var repo: Repository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        ownerName = intent.getStringExtra(RepositoriesActivity.EXTRA_OWNER_NAME).apply {  }
        repoName = intent.getStringExtra(RepositoriesActivity.EXTRA_REPO_NAME)

        XLog.d("ownerName: $ownerName ,repoName: $repoName")
        if (!checkFullName()) {
            progressHUD.showSomethingIsWrongError()
            refresh_layout.isEnableRefresh = false
            return
        }
        initView()
        showLoading()
        loadData()
    }

    private fun checkFullName(): Boolean {
        if (TextUtils.isEmpty(ownerName)) {
            return false
        }
        if (TextUtils.isEmpty(repoName)) {
            return false
        }
        return true
    }

    private fun loadData() {
        presenter.getData(ownerName!!, repoName!!)
    }

    private fun initView() {
        refresh_layout.setOnRefreshListener {
           loadData()
        }

        tv_name.text = repoName
    }

    @SuppressLint("SetTextI18n")
    override fun setData(repository: Repository) {
        this.repo = repository

        dismissLoading()
        refresh_layout.finishRefresh()

        Glide.with(this)
                .load(repository.owner.avatar_url)
                .apply(RequestOptions().placeholder(R.drawable.avatar))
                .into(iv_avatar)

        tv_name.text = repository.name
        tv_desc.text = repository.description
        tv_stars.text = repository.stargazers_count.toString()
        val subscribersCount = if (repository.subscribers_count == 1) repository.subscribers_count - 1 else repository.subscribers_count
        tv_watchers.text = subscribersCount.toString()
        tv_forks.text = repository.forks_count.toString()

        tv_private.text = if (repository.private) "Private" else "Public"
        tv_language.text = if (TextUtils.isEmpty(repository.language)) "--" else repository.language
        tv_open_issues.text = "${repository.open_issues_count} Issues"
        tv_branches.text = "${repository.branches_count} Branchers"

        tv_created_at.text = repository.created_at.subSequence(0,10)
        tv_size.text = Formatter.formatFileSize(this,repository.size)

        tv_owner.text = repository.owner.login

        ll_forked_from.visibility = if (repository.parent == null) View.GONE else View.VISIBLE

        iv_avatar.setOnClickListener(this)
        ll_stars.setOnClickListener(this)
        ll_watchers.setOnClickListener(this)
        ll_forks.setOnClickListener(this)

        rl_owner.setOnClickListener(this)
        rl_forked_from.setOnClickListener(this)

        rl_events.setOnClickListener(this)
        rl_issues.setOnClickListener(this)
        rl_readme.setOnClickListener(this)

        rl_commits.setOnClickListener(this)
        rl_pull_reqs.setOnClickListener(this)
        rl_source.setOnClickListener(this)
    }

    override fun showError() {
        progressHUD.dismissImmediately()
        progressHUD.showSomethingIsWrongError()
        refresh_layout.finishRefresh(false)
    }

    override fun onClick(v: View) {
        val ownerName = repo!!.owner.login
        val repoName = repo!!.name

        when(v.id) {
            R.id.iv_avatar, R.id.rl_owner -> {
                val intent = Intent(getContext(),ProfileActivity::class.java)
                intent.putExtra(EXTRA_USERNAME,repo!!.owner.login)
                startActivity(intent)
            }
            R.id.ll_stars       ->  UsersActivity.startStargazers(this, ownerName, repoName)
            R.id.ll_watchers    ->  UsersActivity.startWatchers(this, ownerName, repoName)
            R.id.ll_forks       ->  RepositoriesActivity.startForks(this, ownerName, repoName)
            R.id.rl_forked_from ->  RepositoryActivity.start(this, repo!!.parent!!.owner.login, repo!!.parent!!.name)
            R.id.rl_events      ->  EventsActivity.startRepoEvents(this, ownerName, repoName)
            R.id.rl_issues      ->  IssuesActivity.start(this, ownerName, repoName)
            R.id.rl_commits     ->  showLongToast("TODO")
            R.id.rl_pull_reqs   ->  showLongToast("TODO")
            R.id.rl_source      ->  showLongToast("TODO")
            R.id.rl_readme      ->  {
                val docUrl = "https://raw.githubusercontent.com/$ownerName/$repoName/${repo!!.default_branch}/README.md"
                MarkdownActivity.start(this,"Readme", docUrl)
            }
        }
    }
}

