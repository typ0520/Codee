package com.github.typ0520.codee.base;

/**
 * Created by tong on 2017/12/21.
 */
abstract class BaseMvpActivity<out V : IBaseView, out P : IPresenter<V>> : BaseActivity(),IBaseView {
    abstract fun createPresenter(): P

    protected val presenter: P by lazy {
        val p = createPresenter()
        p.attachView(this)
        return@lazy p
    }


    override fun onDestroy() {
        super.onDestroy()

        presenter.detachView()
    }
}
