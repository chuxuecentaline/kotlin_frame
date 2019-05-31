package com.cherish.common.widget.drop

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/30 13:17
 * @version: 2.0
 */
interface IMenuContent {
    fun loadData(temp: ArrayList<MenuEntity>)

    fun setCommitCallback(callback: CommitCallback)

    fun gone()
}