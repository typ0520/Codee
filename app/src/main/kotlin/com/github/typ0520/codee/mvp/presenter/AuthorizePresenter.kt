package com.github.typ0520.codee.mvp.presenter

import android.arch.lifecycle.Lifecycle
import com.github.typ0520.codee.base.BasePersenter
import com.github.typ0520.codee.mvp.contract.AuthorizeContract
import com.github.typ0520.codee.utils.parseQueryString
import com.orhanobut.hawk.Hawk
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by tong on 2017-12-21.
 */
class AuthorizePresenter : BasePersenter<AuthorizeContract.View>(), AuthorizeContract.Presenter {
    override fun getAccessToken(code: String) {
        model.requestAccessToken(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .bindUntilEvent(view!!, Lifecycle.Event.ON_DESTROY)
                .subscribeBy(
                        onNext = {
                            //access_token=b615674af1e327def02dcee659b5d3517cdf2dd6&scope=&token_type=bearer
                            //error=bad_verification_code&error_description=The+code+passed+is+incorrect+or+expired.&error_uri=https%3A%2F%2Fdeveloper.github.com%2Fv3%2Foauth%2F%23bad-verification-code
                            val map = it.parseQueryString()
                            val accessToken = map["access_token"]
                            val error = map["error"]

                            if (accessToken != null) {
                                Hawk.put("access_token",accessToken)
                                view?.setAccessToken(accessToken)
                            }
                            if (error != null) {
                                view?.showError(error)
                            }
                        },
                        onError = {
                            it.printStackTrace()
                            view?.showError()
                        }
                )
    }
}
