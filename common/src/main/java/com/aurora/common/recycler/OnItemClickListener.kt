package com.aurora.common.recycler

/**
 * @author: aurora
 * @description: 点击事件
 * @date: 2019/5/9 13:32
 * @version: 2.0
 */
interface OnItemClickListener<T> {
    fun onClick(position:Int,data:T)
}