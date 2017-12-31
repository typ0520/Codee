package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import android.text.TextUtils
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.bean.Issue
import com.github.typ0520.codee.mvp.contract.IssuesContract
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-30.
 */
class IssuesPresenter(val ownerName: String, val repoName: String) : BasePersenter<IssuesContract.View>(), IssuesContract.Presenter {
    var page = 1

    override fun getData(state: String, creator: String?) {
        page = 1
        getObservable(page, state, creator)
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

    override fun loadMore(state: String, creator: String?) {
        getObservable(page + 1, state, creator)
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

    private fun getObservable(page: Int, state: String, creator: String?): Observable<List<Issue>> {
        return if (TextUtils.isEmpty(creator)) {
            model.getIssues(ownerName, repoName, state, page)
        } else {
            model.getUserIssues(ownerName, repoName, state, creator!!, page)
        }
    }
}
