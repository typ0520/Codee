package com.github.typ0520.codee.ui.fragment

import android.graphics.Color
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.TypedValue
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseMvpFragment
import com.github.typ0520.codee.loadsir.ErrorCallback
import com.github.typ0520.codee.loadsir.LoadingCallback
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.contract.TrendingContract
import com.github.typ0520.codee.mvp.presenter.TrendingPresenter
import com.github.typ0520.codee.ui.activity.MainActivity
import com.github.typ0520.codee.ui.adapter.RepositoryAdapter
import com.github.typ0520.codee.ui.widget.FloatingItemDecoration
import com.github.typ0520.codee.utils.showLongToast
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.zhy.fabridge.lib.Fabridge
import kotlinx.android.synthetic.main.fragment_trending.*

/**
 * Created by tong on 2017/12/30.
 */
class TrendingFragment : BaseMvpFragment<TrendingContract.View, TrendingContract.Presenter>(), TrendingContract.View {
    companion object {
        fun newInstance(): TrendingFragment {
            val fragment = TrendingFragment()
            return fragment
        }
    }

    override fun getLayoutId() = R.layout.fragment_trending

    override fun createPresenter() = TrendingPresenter()

    private val adapter by lazy { RepositoryAdapter(mActivity!!) }

    private var loadService: LoadService<Any>? = null

    private lateinit var floatingItemDecoration: FloatingItemDecoration

    private var language: String = ""

    override fun initView() {
        toolbar.setNavigationOnClickListener {
            Fabridge.call(mActivity, MainActivity.EVENT_SHOW_OR_HIDE_DRAWER)
        }

        recycler_view.layoutManager = LinearLayoutManager(mActivity)
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adapter

        floatingItemDecoration = FloatingItemDecoration(mActivity!!, Color.GRAY, 1.0f, 1.0f)
        floatingItemDecoration.setTitleHeight(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 27f, resources.displayMetrics).toInt())
        recycler_view.addItemDecoration(floatingItemDecoration)

        //display loading
        loadService = LoadSir.getDefault().register(recycler_view, {
            loadService?.showCallback(LoadingCallback::class.java)
            loadData()
        })
        loadService?.showCallback(LoadingCallback::class.java)

        ll_language.setOnClickListener { showLongToast("TODO") }
    }

    override fun loadData() {
        presenter.getData(language)
    }

    override fun setData(triple: Triple<List<Repository>, List<Repository>, List<Repository>>) {
        val map = HashMap<Int, String>()
        map.put(0, "Daily")
        map.put(triple.first.size, "Weekly")
        map.put(triple.first.size + triple.second.size, "Monthly")
        floatingItemDecoration.setKeys(map)

        val repositories = ArrayList<Repository>()
        repositories.addAll(triple.first)
        repositories.addAll(triple.second)
        repositories.addAll(triple.third)

        adapter.refresh(repositories)
        loadService?.showSuccess()
    }

    override fun showError() {
        loadService?.showCallback(ErrorCallback::class.java)
    }
}