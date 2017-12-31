package com.github.typ0520.codee.ui.widget

import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.github.typ0520.codee.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SimpleViewHolder(itemView: View, private val mListener: AdapterView.OnItemClickListener?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)

        /**
         * 设置水波纹背景
         */
        if (itemView.background == null) {
            val typedValue = TypedValue()
            val theme = itemView.context.theme
            val top = itemView.paddingTop
            val bottom = itemView.paddingBottom
            val left = itemView.paddingLeft
            val right = itemView.paddingRight
            if (theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)) {
                itemView.setBackgroundResource(typedValue.resourceId)
            }
            itemView.setPadding(left, top, right, bottom)
        }
    }

    override fun onClick(v: View) {
        if (mListener != null) {
            val position = adapterPosition
            if (position >= 0) {
                mListener.onItemClick(null, v, position, itemId)
            }
        }
    }

    fun findViewById(@IdRes id: Int): View? {
        return if (id == 0) itemView else itemView.findViewById(id)
    }

    fun text(@IdRes id: Int, sequence: CharSequence): SimpleViewHolder {
        val view = findViewById(id)
        if (view is TextView) {
            view.text = sequence
        }
        return this
    }

    fun text(@IdRes id: Int, @StringRes stringRes: Int): SimpleViewHolder {
        val view = findViewById(id)
        (view as? TextView)?.setText(stringRes)
        return this
    }

    fun textColorId(@IdRes id: Int, colorId: Int): SimpleViewHolder {
        val view = findViewById(id)
        (view as? TextView)?.setTextColor(ContextCompat.getColor(view.getContext(), colorId))
        return this
    }

    fun image(@IdRes id: Int, imageId: Int): SimpleViewHolder {
        val view = findViewById(id)
        (view as? ImageView)?.setImageResource(imageId)
        return this
    }

    fun image(@IdRes id: Int, imageUrl: String, @DrawableRes placeholder: Int = R.drawable.avatar): SimpleViewHolder {
        val view = findViewById(id)
        (view as? ImageView)?.run {
            Glide.with(view.context)
                    .load(imageUrl)
                    .apply(RequestOptions().placeholder(placeholder))
                    .into(view)
        }
        return this
    }

    fun gone(@IdRes id: Int): SimpleViewHolder {
        val view = findViewById(id)
        view?.visibility = View.GONE
        return this
    }

    fun gone(@IdRes id: Int, block: () -> Boolean): SimpleViewHolder {
        if (block.invoke()) {
            gone(id)
        }
        return this
    }

    fun show(@IdRes id: Int): SimpleViewHolder {
        val view = findViewById(id)
        view?.visibility = View.VISIBLE
        return this
    }

    fun show(@IdRes id: Int, block: () -> Boolean): SimpleViewHolder {
        if (block.invoke()) {
            show(id)
        }

        return this
    }

    fun hide(@IdRes id: Int): SimpleViewHolder {
        val view = findViewById(id)
        view?.visibility = View.INVISIBLE
        return this
    }

    fun hide(@IdRes id: Int, block: () -> Boolean): SimpleViewHolder {
        if (block.invoke()) {
            hide(id)
        }
        return this
    }

    fun click(@IdRes id: Int, block: (view: View) -> Unit): SimpleViewHolder {
        val view = findViewById(id)
        view?.setOnClickListener(block)
        return this
    }
}