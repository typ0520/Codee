package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.bean.Repository
import com.github.typ0520.codee.mvp.contract.RepositoriesContract
import com.github.typ0520.codee.ui.activity.RepositoriesActivity
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-29.
 */
class RepositoriesPresenter(val modelType: String, val ownerName: String, val repoName: String?) : BasePersenter<RepositoriesContract.View>(), RepositoriesContract.Presenter {
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

    private fun getObservable(page: Int): Observable<List<Repository>> {
        return when(modelType) {
            RepositoriesActivity.MODEL_TYPE_FORKS   -> model.getForks(ownerName = ownerName, repoName = repoName!! ,page = page)
            RepositoriesActivity.MODEL_TYPE_OWNED   -> model.getUserRepos(ownerName = ownerName,page = page)
            RepositoriesActivity.MODEL_TYPE_STARRED -> model.getStarredRepos(ownerName = ownerName,page = page)
            else -> {
                throw IllegalArgumentException("Unrecognized model type: $modelType")
            }
        }
    }
}
