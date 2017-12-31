package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.contract.RepositoryContract
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-28.
 */
class RepositoryPresenter : BasePersenter<RepositoryContract.View>(), RepositoryContract.Presenter {
    override fun getData(ownerName: String, repoName: String) {

        model.getRepository(ownerName, repoName)
                .zipWith(model.getBranches(ownerName, repoName), { repo, branches -> repo.apply { branches_count = branches.size } })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            view?.setData(it)
                        },
                        onError = {
                            it.printStackTrace()
                            view?.showError()
                        }
                )
    }
}
