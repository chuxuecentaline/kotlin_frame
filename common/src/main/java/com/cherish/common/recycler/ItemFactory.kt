package com.cherish.common.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/17 14:50
 * @version: 2.0
 */
interface ItemFactory<VH : RecyclerView.ViewHolder, S> {

    fun createViewHolder(viewType: Int, itemView: View, support: S): VH
}