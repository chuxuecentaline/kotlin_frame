package com.aurora.common.widget.view.search

/**
 * @author: aurora
 * @description: 搜索回调
 * @date: 2019/5/29 10:31
 * @version: 2.0
 */
interface SearchCallBack {
    /**
     * 搜索
     */
    fun onSearch(search: String)

    /**
     * 清空
     */
    fun onClear()
}