package com.cherish.common.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cherish.common.R

/**
 * @author: cherish
 * @description: 通用分割线
 * @date: 2019/5/30 16:47
 * @version: 2.0
 */
class CommonItemDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private var height: Int = context.resources.getDimensionPixelOffset(R.dimen.spacing_1)
    private val mPaint: Paint by lazy {
        Paint()
    }

    init {
        mPaint.color = ContextCompat.getColor(context,R.color.material_grey_100)
        mPaint.isAntiAlias=true
        mPaint.isDither=true
    }


    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val count = parent.childCount
        for (position in 0 until count) {
            val view = parent.getChildAt(position)
            c.drawRect(0.toFloat(), view.bottom.toFloat(), view.measuredWidth.toFloat(), view.bottom.toFloat() + height, mPaint)
        }
    }
}