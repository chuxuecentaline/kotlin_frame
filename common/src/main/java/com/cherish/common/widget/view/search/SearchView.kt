package com.cherish.common.widget.view.search

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * @author: cherish
 * @description: 搜索控件
 * @date: 2019/5/27 15:20
 * @version: 2.0
 */
class SearchView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {
    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)
    init {

    }

    override fun onFinishInflate() {
        super.onFinishInflate()
    }
}