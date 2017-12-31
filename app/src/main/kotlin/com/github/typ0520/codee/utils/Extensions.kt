package com.github.typ0520.codee.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.github.typ0520.codee.CodeeApplication
import com.github.typ0520.codee.R
import com.github.typ0520.codee.base.BaseFragment
import com.bigkoo.svprogresshud.SVProgressHUD
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.elvishew.xlog.XLog
import io.reactivex.Observable
import java.net.UnknownHostException

/**
 * Created by tong on 2017/12/21.
 */
fun Activity.showLongToast(text: CharSequence) {
    Toast.makeText(this,text,Toast.LENGTH_LONG).show()
}

fun Activity.showLongToast(resId: Int) {
    Toast.makeText(this,resId,Toast.LENGTH_LONG).show()
}

fun Activity.showShortToast(text: CharSequence) {
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}

fun Activity.showShortToast(resId: Int) {
    Toast.makeText(this,resId,Toast.LENGTH_SHORT).show()
}

fun BaseFragment.showLongToast(text: CharSequence) {
    Toast.makeText(mActivity,text, Toast.LENGTH_LONG).show()
}

fun BaseFragment.showLongToast(resId: Int) {
    Toast.makeText(mActivity,resId, Toast.LENGTH_LONG).show()
}

fun BaseFragment.showShortToast(text: CharSequence) {
    Toast.makeText(mActivity,text, Toast.LENGTH_SHORT).show()
}

fun BaseFragment.showShortToast(resId: Int) {
    Toast.makeText(mActivity,resId, Toast.LENGTH_SHORT).show()
}

fun String.parseQueryString(): Map<String,String> {
    val map = HashMap<String,String>()

    split("&").forEach {
        val list = it.split("=")
        map.put(list[0],list[1])
    }
    return map
}

fun String.formatCreatedAt(): String {
    return "TODO formatCreatedAt"
}

fun View.gone() {
    visibility = View.GONE
}

fun View.gone(block: () -> Boolean) {
    if (block.invoke()) {
        gone()
    }
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.hide(block: () -> Boolean) {
    if (block.invoke()) {
        hide()
    }
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.show(block: () -> Boolean) {
    if (block.invoke()) {
        show()
    }
}

fun View.showElseGone(block: () -> Boolean) {
    if (block.invoke()) {
        show()
    }
    else {
        gone()
    }
}

fun View.showElseHide(block: () -> Boolean) {
    if (block.invoke()) {
        show()
    }
    else {
        hide()
    }
}

fun View.goneElseShow(block: () -> Boolean) {
    if (!block.invoke()) {
        show()
    }
    else {
        gone()
    }
}

fun View.hideElseShow(block: () -> Boolean) {
    if (!block.invoke()) {
        show()
    }
    else {
        hide()
    }
}

fun ImageView.setImageUrl(url: String) {
    Glide.with(context)
            .load(url)
            .into(this)
}

fun ImageView.setImageUrl(url: String, placeholder: Int) {
    Glide.with(context)
            .load(url)
            .apply(RequestOptions().placeholder(placeholder))
            .into(this)
}

fun SVProgressHUD.showSomethingIsWrongError() {
    this.showErrorWithStatus(CodeeApplication.context.getString(R.string.something_is_wrong),SVProgressHUD.SVProgressHUDMaskType.GradientCancel)
}

fun <T> Observable<T>.lotteryRetry(): io.reactivex.Observable<T> {
    return this.retry(3, {
        XLog.d("retry")
        it is UnknownHostException
    })
}

//
//
//class BaseOnQueryTextListener: OnQueryTextListener {
//    override fun onQueryTextSubmit(query: String?): Boolean {
//        return false
//    }
//
//    override fun onQueryTextChange(newText: String?): Boolean {
//        return false
//    }
//}
//
//fun SearchView.setOnQueryTextSubmitListener(block: (query: String?) -> Boolean) {
//    setOnQueryTextListener(OnQueryTextListener() {
//         fun onQueryTextSubmit(query: String): Boolean {
//
//        }
//    })
//}