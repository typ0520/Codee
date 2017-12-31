package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.contract.LoginContract
import com.github.typ0520.codee.utils.lotteryRetry
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-22.
 */
class LoginPresenter : BasePersenter<LoginContract.View>(), LoginContract.Presenter {
    override fun getUserInfo(accessToken: String) {
        model.getUserInfoByAccessToken(accessToken)
                .lotteryRetry()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            it.access_token = accessToken
                            it.save()
                            view?.setUser(it)
                        },
                        onError = {
                            it.printStackTrace()
                            view?.showError()
                        }
                )
    }
}