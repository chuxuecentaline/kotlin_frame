package com.cherish.common.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: cherish
 * @description: 简单的recyclerView
 * @date: 2019/5/23 14:22
 * @version: 2.0
 */
abstract class SimpleBaseAdapter<T, VH : RecyclerView.ViewHolder>(var mList: ArrayList<T>) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = initViewHolder(parent, viewType)

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        convertHolder(holder, position)
    }

    /**
     * 更新
     */
    fun setData(list: ArrayList<T>) {
        mList = list
        notifyDataSetChanged()
    }

    /**
     * 更多
     */
    fun loadMoreData(list: ArrayList<T>) {
        val size = mList.size
        mList.addAll(list)
        notifyItemMoved(size, mList.size)
    }

    abstract fun initViewHolder(parent: ViewGroup, viewType: Int): VH
    abstract fun convertHolder(holder: VH, position: Int)

}