package com.github.typ0520.codee.ui.widget

import android.database.DataSetObservable
import android.database.DataSetObserver
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter

/**
 * Created by tong on 2017/12/29.
 */
abstract class SimpleRecyclerAdapter<T> : BaseRecyclerAdapter<T, SimpleViewHolder>, ListAdapter {
    private val mLayoutId: Int
    private var mLastPosition = -1
    private var mOpenAnimationEnable = true
    private var mListener: AdapterView.OnItemClickListener? = null

    private val mDataSetObservable = DataSetObservable()

    constructor(@LayoutRes layoutId: Int) {
        setHasStableIds(false)
        this.mLayoutId = layoutId
    }

    constructor(collection: Collection<T>, @LayoutRes layoutId: Int): super(collection) {
        setHasStableIds(false)
        this.mLayoutId = layoutId
    }

    constructor(collection: Collection<T>, @LayoutRes layoutId: Int, listener: AdapterView.OnItemClickListener): super(collection) {
        setHasStableIds(false)
        setOnItemClickListener(listener)
        this.mLayoutId = layoutId
    }

    private fun addAnimate(holder: SimpleViewHolder?, postion: Int) {
        if (mOpenAnimationEnable && mLastPosition < postion) {
            holder!!.itemView.alpha = 0f
            holder.itemView.animate().alpha(1f).start()
            mLastPosition = postion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(LayoutInflater.from(parent.context).inflate(mLayoutId, parent, false), mListener)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        onBindViewHolder(holder, if (position < mList.size) mList[position] else null, position)
    }

    protected abstract fun onBindViewHolder(holder: SimpleViewHolder, model: T?, position: Int)

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onViewAttachedToWindow(holder: SimpleViewHolder?) {
        super.onViewAttachedToWindow(holder)
        addAnimate(holder, holder!!.layoutPosition)
    }

    fun setOpenAnimationEnable(enable: Boolean) {
        this.mOpenAnimationEnable = enable
    }

    //</editor-fold>

    //<editor-fold desc="API">

    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener): SimpleRecyclerAdapter<T> {
        mListener = listener
        return this
    }

    override fun refresh(collection: Collection<T>): SimpleRecyclerAdapter<T> {
        super.refresh(collection)
        notifyListDataSetChanged()
        mLastPosition = -1
        return this
    }

    override fun loadmore(collection: Collection<T>): SimpleRecyclerAdapter<T> {
        super.loadmore(collection)
        notifyListDataSetChanged()
        return this
    }

    override fun registerDataSetObserver(observer: DataSetObserver) {
        mDataSetObservable.registerObserver(observer)
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver) {
        mDataSetObservable.unregisterObserver(observer)
    }

    /**
     * Notifies the attached observers that the underlying data has been changed
     * and any View reflecting the data set should refresh itself.
     */
    fun notifyListDataSetChanged() {
        mDataSetObservable.notifyChanged()
    }

    /**
     * Notifies the attached observers that the underlying data is no longer valid
     * or available. Once invoked this adapter is no longer valid and should
     * not report further data set changes.
     */
    fun notifyDataSetInvalidated() {
        mDataSetObservable.notifyInvalidated()
    }

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun isEnabled(position: Int): Boolean {
        return true
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: SimpleViewHolder
        if (convertView != null) {
            holder = convertView.tag as SimpleViewHolder
        } else {
            holder = onCreateViewHolder(parent, getItemViewType(position))
            convertView = holder.itemView
            convertView!!.tag = holder
        }
        onBindViewHolder(holder, position)
        addAnimate(holder, position)
        return convertView
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    fun clearData() {
        mList.clear()
    }
}

class Listener1(val block: (parent: AdapterView<*>?, view: View?, position: Int, id: Long) -> Unit): AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        block.invoke(parent, view, position, id)
    }
}

class Listener2<T>(val adapter: SimpleRecyclerAdapter<T>, val block: (position: Int, model: T?) -> Unit): AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        block.invoke(position, adapter.getItem(position))
    }
}

fun <T> SimpleRecyclerAdapter<T>.setOnItemClickListener(block: (parent: AdapterView<*>?, view: View?, position: Int, id: Long) -> Unit): SimpleRecyclerAdapter<T> {
    setOnItemClickListener(Listener1(block))
    return this
}

fun <T> SimpleRecyclerAdapter<T>.setOnItemClickListener(block: (position: Int, model: T?) -> Unit): SimpleRecyclerAdapter<T> {
    setOnItemClickListener(Listener2(this, block))
    return this
}

class Adapter1<T>(@LayoutRes layoutId: Int, private val binder: (holder: SimpleViewHolder, model: T?, position: Int) -> Unit): SimpleRecyclerAdapter<T>(layoutId) {
    override fun onBindViewHolder(holder: SimpleViewHolder, model: T?, position: Int) {
        binder.invoke(holder, model, position)
    }
}

fun <T> adapter1(@LayoutRes layoutId: Int, binder: (holder: SimpleViewHolder, model: T?, position: Int) -> Unit) = Adapter1<T>(layoutId, binder)