package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.bean.EventList
import com.github.typ0520.codee.mvp.bean.User
import com.github.typ0520.codee.mvp.contract.EventsContract
import com.github.typ0520.codee.ui.fragment.EventsFragment
import com.orhanobut.hawk.Hawk
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017/12/20.
 */
class EventsPresenter(val modelType: String, val ownerName: String, val repoName: String?) : BasePersenter<EventsContract.View>(), EventsContract.Presenter {
    val username: String by lazy { Hawk.get<User>(User.PREFS_KEY).login }
    var page = 1

    override fun getData() {
        page = 1
        getObservable(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .retry()
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

    private fun getObservable(page: Int): Observable<EventList> {
        return when(modelType) {
            EventsFragment.MODEL_TYPE_NEWS   -> model.getReceivedEvents(ownerName, page)
            EventsFragment.MODEL_TYPE_EVNETS   -> model.getUserEvents(ownerName, page)
            EventsFragment.MODEL_TYPE_REPO_EVENTS -> model.getRepoEvents(ownerName, repoName!!, page)
            else -> {
                throw IllegalArgumentException("Unrecognized model type: $modelType")
            }
        }
    }
}
