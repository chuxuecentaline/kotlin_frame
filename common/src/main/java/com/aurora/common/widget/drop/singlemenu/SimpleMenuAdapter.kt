package com.aurora.common.widget.drop.singlemenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.aurora.common.R
import com.aurora.common.recycler.BaseViewHolder
import com.aurora.common.recycler.SimpleBaseAdapter
import com.aurora.common.widget.drop.MenuEntity

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/30 16:33
 * @version: 2.0
 */
class SimpleMenuAdapter : SimpleBaseAdapter<MenuEntity, SimpleMenuViewHolder>(arrayListOf()) {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): SimpleMenuViewHolder {

        return SimpleMenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_simple, parent, false))
    }

    override fun onBindItemClickListener(itemView: View, position: Int, bean: MenuEntity) {
    }
}

class SimpleMenuViewHolder(view: View) : BaseViewHolder<MenuEntity>(view) {

    private lateinit var mAtvContext: AppCompatTextView

    override fun findView(itemView: View) {
        mAtvContext = itemView.findViewById(R.id.atv_content)
    }

    override fun bindTo(bean: MenuEntity) {
        mAtvContext.apply {
            text=bean.title
        }
        if(bean.isSelected){
            mAtvContext.setTextColor(color(R.color.colorAccent))
        }else{
            mAtvContext.setTextColor(color(R.color.color_333333))
        }
    }

}