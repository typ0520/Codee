package com.github.typ0520.codee.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.annotation.Dimension
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.TypedValue
import android.view.View
import com.github.typ0520.codee.R

class FloatingItemDecoration : RecyclerView.ItemDecoration {
    companion object {
        private val ATTRS = intArrayOf(android.R.attr.listDivider)
    }

    private var divider: Drawable? = null
    private var dividerHeight: Int = 0
    private var dividerWidth: Int = 0
    private var keys = mutableMapOf<Int, String>()
    private var titleHeight: Int = 0
    private var textPaint: Paint? = null
    private var backgroundPaint: Paint? = null
    private var textHeight: Float = 0.toFloat()
    private var textBaselineOffset: Float = 0.toFloat()
    private var context: Context? = null

    private var showFloatingHeaderOnScrolling = true

    constructor(context: Context) {
        val a = context.obtainStyledAttributes(ATTRS)
        divider = a.getDrawable(0)
        a.recycle()
        this.dividerHeight = divider!!.intrinsicHeight
        this.dividerWidth = divider!!.intrinsicWidth
        init(context)
    }

    constructor(context: Context, @DrawableRes drawableId: Int) {
        divider = ContextCompat.getDrawable(context, drawableId)
        this.dividerHeight = divider!!.intrinsicHeight
        this.dividerWidth = divider!!.intrinsicWidth
        init(context)
    }

    constructor(context: Context, @ColorInt color: Int, @Dimension dividerWidth: Float, @Dimension dividerHeight: Float) {
        divider = ColorDrawable(color)
        this.dividerWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dividerWidth, context.resources.displayMetrics).toInt()
        this.dividerHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dividerHeight, context.resources.displayMetrics).toInt()
        init(context)
    }

    private fun init(mContext: Context) {
        this.context = mContext
        textPaint = Paint()
        textPaint!!.isAntiAlias = true
        textPaint!!.textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, mContext.resources.displayMetrics)
        textPaint!!.color = Color.WHITE
        val fm = textPaint!!.fontMetrics
        textHeight = fm.bottom - fm.top//计算文字高度
        textBaselineOffset = fm.bottom

        backgroundPaint = Paint()
        backgroundPaint!!.isAntiAlias = true
        backgroundPaint!!.color = ContextCompat.getColor(context, R.color.colorPrimary)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDraw(c, parent, state)
        drawVertical(c, parent)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        super.onDrawOver(c, parent, state)
        if (!showFloatingHeaderOnScrolling) {
            return
        }
        val firstVisiblePos = (parent.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (firstVisiblePos == RecyclerView.NO_POSITION) {
            return
        }
        val title = getTitle(firstVisiblePos)
        if (TextUtils.isEmpty(title)) {
            return
        }
        var flag = false
        if (getTitle(firstVisiblePos + 1) != null && title != getTitle(firstVisiblePos + 1)) {
            val child = parent.findViewHolderForAdapterPosition(firstVisiblePos).itemView
            if (child.top + child.measuredHeight < titleHeight) {
                c.save()
                flag = true
                c.translate(0f, (child.top + child.measuredHeight - titleHeight).toFloat())
            }
        }
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        val top = parent.paddingTop
        val bottom = top + titleHeight
        c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), backgroundPaint!!)
        val x = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, context!!.resources.displayMetrics)
        val y = bottom.toFloat() - (titleHeight - textHeight) / 2 - textBaselineOffset

        val rect = Rect()
        textPaint!!.getTextBounds(title!!, 0 ,1, rect)

        val centreX = (right - left) / 2.0f
        val titleWidth = (rect.right - rect.left)
        val titleX = centreX - (2.5f * titleWidth)
        c.drawText(title!!, titleX, y, textPaint!!)
        if (flag) {
            c.restore()
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val pos = parent.getChildViewHolder(view).adapterPosition
        if (keys.containsKey(pos)) {
            outRect.set(0, titleHeight, 0, 0)
        } else {
            outRect.set(0, dividerHeight, 0, 0)
        }
    }

    private fun getTitle(position: Int): String? {
        var position = position
        while (position >= 0) {
            if (keys.containsKey(position)) {
                return keys[position]
            }
            position--
        }
        return null
    }

    private fun drawVertical(c: Canvas, parent: RecyclerView) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight
        var top = 0
        var bottom = 0
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            if (!keys.containsKey(params.viewLayoutPosition)) {
                top = child.top - params.topMargin - dividerHeight
                bottom = top + dividerHeight
                divider!!.setBounds(left, top, right, bottom)
                divider!!.draw(c)
            } else {
                top = child.top - params.topMargin - titleHeight
                bottom = top + titleHeight
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), backgroundPaint!!)
                val x = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, context!!.resources.displayMetrics)
                val y = bottom.toFloat() - (titleHeight - textHeight) / 2 - textBaselineOffset

                val text = keys[params.viewLayoutPosition]

                val rect = Rect()
                textPaint!!.getTextBounds(text, 0 ,1, rect)
                val centreX = (right - left) / 2.0f
                val titleWidth = (rect.right - rect.left)
                val titleX = centreX - (2.5f * titleWidth)
                c.drawText(text, titleX, y, textPaint!!)
            }
        }
    }

    fun setShowFloatingHeaderOnScrolling(showFloatingHeaderOnScrolling: Boolean) {
        this.showFloatingHeaderOnScrolling = showFloatingHeaderOnScrolling
    }

    fun setKeys(keys: Map<Int, String>) {
        this.keys.clear()
        this.keys.putAll(keys)
    }

    fun setTitleHeight(titleHeight: Int) {
        this.titleHeight = titleHeight
    }
}