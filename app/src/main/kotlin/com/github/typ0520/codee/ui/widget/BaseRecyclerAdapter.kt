package com.github.typ0520.codee.ui.widget

import android.support.v7.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by tong on 2017/12/30.
 */
abstract class BaseRecyclerAdapter<T, VH: RecyclerView.ViewHolder> : RecyclerView.Adapter<VH> {
    protected val mList: MutableList<T>

    constructor() {
        this.mList = ArrayList()
    }

    constructor(collection: Collection<T>) {
        this.mList = ArrayList(collection)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun isEmpty(): Boolean {
        return mList.isEmpty()
    }

    fun getItem(position: Int): T? {
        return mList[position]
    }

    fun getCount(): Int {
        return mList.size
    }

    open fun refresh(collection: Collection<T>): BaseRecyclerAdapter<T, VH> {
        mList.clear()
        mList.addAll(collection)
        notifyDataSetChanged()
        return this
    }

    open fun loadmore(collection: Collection<T>): BaseRecyclerAdapter<T, VH> {
        mList.addAll(collection)
        notifyDataSetChanged()
        return this
    }
}