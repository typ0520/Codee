package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.contract.SearchContract
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-30.
 */
class SearchPresenter : BasePersenter<SearchContract.View>(), SearchContract.Presenter {
    override fun searchRepositories(query: String) {
        model.searchRepositories(query, per_page = 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            view?.setRepositories(it.items)
                        },
                        onError = {
                            view?.showError()
                        }
                )
    }

    override fun searchUsers(query: String){
        model.searchUsers(query, per_page = 100)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            view?.setUsers(it.items)
                        },
                        onError = {
                            view?.showError()
                        }
                )
    }
}
