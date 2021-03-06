package com.aurora.common.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * BaseViewHolder
 *
 * Created by aurora
 */
abstract class IViewHolder<E, S>(itemView: View, val s: S) : RecyclerView.ViewHolder(itemView) {

    protected val support = s

    open fun bind(data: E, payload: List<Any>) {
        bind(data)
    }

    abstract fun bind(data: E)

    fun <T : View> findView(id: Int): T {
        return itemView.findViewById(id)
    }
}