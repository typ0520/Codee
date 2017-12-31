package com.github.typ0520.codee.ui.fragment

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.text.TextUtils
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpFragment
import com.github.typ0520.codee.loadsir.ErrorCallback
import com.github.typ0520.codee.loadsir.LoadingCallback
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.SearchContract
import com.github.typ0520.codee.mvp.presenter.SearchPresenter
import com.github.typ0520.codee.ui.activity.MainActivity
import com.github.typ0520.codee.ui.adapter.RepositoryAdapter
import com.github.typ0520.codee.ui.adapter.UserAdapter
import com.github.typ0520.codee.utils.hide
import com.github.typ0520.codee.utils.show
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.zhy.fabridge.lib.Fabridge
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * Created by tong on 2017/12/30.
 */
class SearchFragment: BaseMvpFragment<SearchContract.View, SearchContract.Presenter>(), SearchContract.View, SearchView.OnQueryTextListener {
    companion object {
        fun newInstance(): SearchFragment {
            val fragment = SearchFragment()
            return fragment
        }
    }

    override fun getLayoutId() = R.layout.fragment_search

    override fun createPresenter() = SearchPresenter()

    private val repositoryAdapter by lazy { RepositoryAdapter(mActivity!!) }
    private val userAdapter by lazy { UserAdapter(mActivity!!) }

    private var loadService: LoadService<Any>? = null
    private var repoMode = true

    override fun initView() {
        toolbar.setNavigationOnClickListener {
            Fabridge.call(mActivity, MainActivity.EVENT_SHOW_OR_HIDE_DRAWER)
        }

        sg.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.btn_repo -> { repoMode = true }
                R.id.btn_users -> { repoMode = false }
            }
        }
        search_View.setOnSearchClickListener { sg.hide() }
        search_View.setOnCloseListener { sg.show().run { false } }
        search_View.setOnQueryTextListener(this)

        recycler_view.layoutManager = LinearLayoutManager(mActivity)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.addItemDecoration(DividerItemDecoration(mActivity, LinearLayoutManager.VERTICAL))

        //display loading
        loadService = LoadSir.getDefault().register(recycler_view)
        loadService?.showSuccess()
    }

    override fun setRepositories(repositories: List<Repository>) {
        loadService?.showSuccess()
        recycler_view.adapter = repositoryAdapter
        repositoryAdapter.refresh(repositories)
    }

    override fun setUsers(users: List<User>) {
        loadService?.showSuccess()
        recycler_view.adapter = userAdapter
        userAdapter.refresh(users)
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (TextUtils.isEmpty(query)) {
            return false
        }
        loadService?.showCallback(LoadingCallback::class.java)

        if (repoMode) {
            presenter.searchRepositories(query!!)
        }
        else {
            presenter.searchUsers(query!!)
        }
        return true
    }

    override fun showError() {
        loadService?.showCallback(ErrorCallback::class.java)
    }
}