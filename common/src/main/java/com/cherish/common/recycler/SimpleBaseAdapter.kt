package com.cherish.common.recycler

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: cherish
 * @description: 简单的recyclerView
 * @date: 2019/5/23 14:22
 * @version: 2.0
 */
abstract class SimpleBaseAdapter<T, VH : BaseViewHolder<T>>(var mList: ArrayList<T>) : RecyclerView.Adapter<VH>() {
    /**
     * 点击事件回调
     */
    lateinit var mListener: OnItemClickListener<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = initViewHolder(parent, viewType)

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindTo(mList[position])
        holder.itemView.setOnClickListener {
            mListener.onClick(position, mList[position])
        }
        onBindItemClickListener(holder.itemView,position,mList[position])
    }

    /**
     * 刷新
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
    abstract fun onBindItemClickListener(itemView: View,position: Int,bean: T)
    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        mListener = listener
    }

}