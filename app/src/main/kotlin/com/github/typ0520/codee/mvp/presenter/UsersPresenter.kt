package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.UsersContract
import com.github.typ0520.codee.ui.activity.UsersActivity
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-29.
 */
class UsersPresenter(val modelType: String, val username: String, val repoName: String?) : BasePersenter<UsersContract.View>(), UsersContract.Presenter {
    var page = 1

    override fun getData() {
        page = 1
        getObservable(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            view?.setData(it,false)
                        },
                        onError = {
                            view?.showError(false)
                        }
                )
    }

    override fun loadMore() {
        getObservable(page + 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            page += 1
                            view?.setData(it,true)
                        },
                        onError = {
                            view?.showError(true)
                        }
                )
    }

    fun getObservable(page: Int): Observable<List<User>> {
        return when(modelType) {
            UsersActivity.MODEL_TYPE_FOLLOWERS -> model.getFollowers(username,page)
            UsersActivity.MODEL_TYPE_FOLLOWING -> model.getFollowing(username,page)
            UsersActivity.MODEL_TYPE_STARGAZERS -> model.getStargazers(username,repoName!!,page)
            UsersActivity.MODEL_TYPE_WATCHERS -> model.getWatchers(username,repoName!!,page)
            else -> {
                throw IllegalArgumentException("Unrecognized model type: $modelType")
            }
        }
    }
}
