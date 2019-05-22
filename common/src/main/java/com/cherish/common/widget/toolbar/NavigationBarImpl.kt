package com.cherish.common.widget.toolbar

import android.view.View

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/21 17:09
 * @version: 2.0
 */
interface NavigationBarImpl<T> {
    fun bindLayoutId(): Int
    fun applyParams(view:View)
    fun navigationCallback(view:View,params:T)
}