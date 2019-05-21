package com.cherish.common.recycler

import android.view.View

/**
 * @author: cherish
 * @description: 列表功能的回调
 * @date: 2019/5/17 14:40
 * @version: 2.0
 */
interface ListCallback {
    fun reload()
    fun itemClick(view: View, position: Int)
}