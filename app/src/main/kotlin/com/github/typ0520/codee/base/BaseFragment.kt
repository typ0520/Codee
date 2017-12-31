package com.github.typ0520.codee.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigkoo.svprogresshud.SVProgressHUD
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * Created by tong on 2017/12/19.
 */
abstract class BaseFragment : RxFragment(), IBaseView {
    companion object {
        val TAG: String = BaseFragment::class.java.simpleName
    }

    abstract fun getLayoutId(): Int

    var mActivity: Activity? = null

    val progressHUD by lazy { SVProgressHUD(mActivity) }

    private var prepared: Boolean = false

    private var onViewCreatedHandler: () -> Unit = {}

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        this.mActivity = activity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(),null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        onViewCreatedHandler.invoke()

        prepared = true
        lazyLoad()
    }

    override fun showLoading(msg: String?) {
        if (msg == null) {
            progressHUD.show()
        }
        else {
            progressHUD.showWithStatus(msg)
        }
    }

    override fun dismissLoading() {
        progressHUD.dismiss()
    }

    open fun initView() {

    }

    open fun loadData() {

    }

    fun lazyLoad() {
        if (userVisibleHint && prepared) {
            loadData()
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoad()
        }
    }

    fun setOnViewCreatedHandler(handler: () -> Unit) {
        this.onViewCreatedHandler = handler
    }
}