package com.github.typ0520.codee.ui.fragment

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpFragment
import com.github.typ0520.codee.base.DEFAULT_PER_PAGE
import com.github.typ0520.codee.loadsir.EmptyCallback
import com.github.typ0520.codee.loadsir.ErrorCallback
import com.github.typ0520.codee.loadsir.LoadingCallback
import com.github.typ0520.codee.mvp.bean.EventList
import com.github.typ0520.codee.mvp.contract.EventsContract
import com.github.typ0520.codee.mvp.presenter.EventsPresenter
import com.github.typ0520.codee.ui.activity.MainActivity
import com.github.typ0520.codee.ui.adapter.EventAdapter
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.zhy.fabridge.lib.Fabridge
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * Created by tong on 2017/12/20.
 */
class EventsFragment : BaseMvpFragment<EventsContract.View, EventsPresenter>(), EventsContract.View {
    companion object {
        val EXTRA_MODEL_TYPE = "model_type"
        val EXTRA_OWNER_NAME = "owner_name"
        val EXTRA_REPO_NAME = "repo_name"

        val MODEL_TYPE_NEWS = "News"
        val MODEL_TYPE_EVNETS = "Events"
        val MODEL_TYPE_REPO_EVENTS = "RepoEvents"

        fun newInstance(arguments: Bundle): EventsFragment {
            val fragment = EventsFragment()
            fragment.arguments = arguments
            return fragment
        }

        fun newInstanceForNews(username: String): EventsFragment = newInstance(MODEL_TYPE_NEWS, username)

        fun newInstanceForEvents(username: String): EventsFragment = newInstance(MODEL_TYPE_EVNETS, username)

        fun newInstanceForRepoEvents(ownerName: String, repoName: String): EventsFragment = newInstance(MODEL_TYPE_REPO_EVENTS, ownerName, repoName)

        private fun newInstance(modelType: String, ownerName: String, repoName: String = ""): EventsFragment {
            val arguments = Bundle()
            arguments.putString(EXTRA_MODEL_TYPE, modelType)
            arguments.putString(EXTRA_OWNER_NAME, ownerName)
            arguments.putString(EXTRA_REPO_NAME, repoName)
            return newInstance(arguments)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_news

    override fun createPresenter() = EventsPresenter(modelType!!, ownerName!!, repoName)

    private val adapter by lazy { EventAdapter(mActivity!!) }

    private var loadService: LoadService<Any>? = null

    private var modelType: String? = null
    private var ownerName: String? = null
    private var repoName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        modelType = arguments.getString(EXTRA_MODEL_TYPE)
        ownerName = arguments.getString(EXTRA_OWNER_NAME)
        repoName = arguments.getString(EXTRA_REPO_NAME)
        checkArguments()
    }

    private fun checkArguments() {
        if (TextUtils.isEmpty(modelType)) {
            throw IllegalArgumentException("modelType con not be null or empty!!")
        }
        if (TextUtils.isEmpty(ownerName)) {
            throw IllegalArgumentException("Username con not be null or empty!!")
        }
        if (modelType.equals(MODEL_TYPE_REPO_EVENTS) && TextUtils.isEmpty(repoName)) {
            throw IllegalArgumentException("Repository name con not be null or empty!!")
        }
    }

    override fun initView() {
        toolbar.title = modelType!!
        toolbar.setNavigationOnClickListener {
            Fabridge.call(mActivity, MainActivity.EVENT_SHOW_OR_HIDE_DRAWER)
        }

        recycler_view.layoutManager = LinearLayoutManager(mActivity)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.addItemDecoration(DividerItemDecoration(mActivity!!, LinearLayoutManager.VERTICAL))
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

    override fun loadData() {
        presenter.getData()
    }

    override fun setData(events: EventList, loadMore: Boolean) {
        if (loadMore) {
            if (events.size < DEFAULT_PER_PAGE) {
                refresh_layout.finishLoadmoreWithNoMoreData()
            }

            if (!events.isEmpty()) {
                refresh_layout.finishLoadmore()
                adapter.loadmore(events)
            }
        }
        else {
            refresh_layout.finishRefresh()
            if (events.isEmpty()) {
                //display no-data view
                loadService?.showCallback(EmptyCallback::class.java)
            }
            else {
                if (events.size < DEFAULT_PER_PAGE) {
                    refresh_layout.finishLoadmoreWithNoMoreData()
                }
                else {
                    refresh_layout.resetNoMoreData()
                }
                loadService?.showSuccess()
            }
            adapter.refresh(events)
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