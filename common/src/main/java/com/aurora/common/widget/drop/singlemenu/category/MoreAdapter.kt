package com.aurora.common.widget.drop.singlemenu.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import com.aurora.common.R
import com.aurora.common.recycler.BaseViewHolder
import com.aurora.common.recycler.SimpleBaseAdapter
import com.aurora.common.widget.drop.MenuEntity

/**
 * @author: aurora
 * @description: 更多分类
 * @date: 2019/5/29 16:29
 * @version: 2.0
 */
class MoreAdapter: SimpleBaseAdapter<MenuEntity, MoreViewHolder>(arrayListOf()) {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): MoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catagory, parent, false)
        return MoreViewHolder(view)

    }

    override fun onBindItemClickListener(itemView: View, position: Int, bean: MenuEntity) {

    }


}

class MoreViewHolder(itemView: View) : BaseViewHolder<MenuEntity>(itemView) {

    private lateinit var mAcbTab: AppCompatCheckBox

    override fun findView(itemView: View) {
        mAcbTab=  itemView.findViewById(R.id.acb_tab)
    }

    override fun bindTo(bean: MenuEntity) {
        mAcbTab.apply {
            text=bean.title
            isChecked=bean.isSelected
        }
    }

}