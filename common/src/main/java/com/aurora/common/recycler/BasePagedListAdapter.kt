package com.aurora.common.recycler

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.aurora.common.entity.BaseEntity

/**
 * @author: aurora
 * @description: PagedListAdapter 分页基类
 * @date: 2019/5/7 15:09
 * @version: 2.0
 */
abstract class BasePagedListAdapter<T : BaseEntity>(POST_COMPARATOR: DiffUtil.ItemCallback<T>) : PagedListAdapter<T, BaseViewHolder<T>>(POST_COMPARATOR) {
    private lateinit var mListener: OnItemClickListener<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return onViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        getItem(position)?.let {
            holder.bindTo(it)
            holder.itemView.setOnClickListener {
                getItem(position)?.let { it1 -> mListener?.onClick(position, it1) }
            }
        }

    }

    /**
     * 设置viewHolder
     */
    abstract fun onViewHolder(parent: ViewGroup): BaseViewHolder<T>

    /**
     * 每项item 的点击事件
     */
    fun setOnItemClickListener(listener: OnItemClickListener<T>) {
        mListener = listener
    }


}