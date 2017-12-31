package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.contract.TrendingContract
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-29.
 */
class TrendingPresenter : BasePersenter<TrendingContract.View>(), TrendingContract.Presenter {
    override fun getData(language: String) {
        //daily weekly monthly
        Observables.zip(model.getTrendingRepos("daily", language),
                model.getTrendingRepos("weekly", language),
                model.getTrendingRepos("monthly", language))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            view?.setData(it)
                        },
                        onError = {
                            view?.showError()
                        }
                )
    }
}
