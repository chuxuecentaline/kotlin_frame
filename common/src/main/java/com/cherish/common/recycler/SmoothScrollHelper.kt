package com.cherish.common.recycler

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: cherish
 * @description: 平滑滚动帮助类
 * @date: 2019/5/20 13:44
 * @version: 2.0
 */
class SmoothScrollHelper(val context: Context, val recyclerView: RecyclerView, val layoutManager: LinearLayoutManager) {
    private val smoothScroller = LinearSmoothScroller(context)

    fun smoothToTop() {
        val position = layoutManager.findFirstCompletelyVisibleItemPosition()
        if (position > -1) {
            if (position > 10) {
                recyclerView.scrollToPosition(10)
            }
            smoothScroller.targetPosition = 0
            layoutManager.startSmoothScroll(smoothScroller)
        }
    }

}