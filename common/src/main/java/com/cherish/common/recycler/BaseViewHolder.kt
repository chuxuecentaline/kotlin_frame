package com.cherish.common.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: cherish
 * @description:BaseViewHolder 基类
 * @date: 2019/5/8 10:47
 * @version: 2.0
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        findView(itemView)
    }

    abstract fun findView(itemView: View)

    abstract fun bindTo(bean: T)


}