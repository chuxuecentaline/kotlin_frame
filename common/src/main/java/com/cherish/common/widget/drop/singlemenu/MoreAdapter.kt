package com.cherish.common.widget.drop.singlemenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import com.cherish.common.R
import com.cherish.common.recycler.BaseViewHolder
import com.cherish.common.recycler.SimpleBaseAdapter
import com.cherish.common.widget.drop.CategoryEntity

/**
 * @author: cherish
 * @description: 更多分类
 * @date: 2019/5/29 16:29
 * @version: 2.0
 */
class MoreAdapter: SimpleBaseAdapter<CategoryEntity, MoreViewHolder>(arrayListOf()) {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): MoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_catagory, parent, false)
        return MoreViewHolder(view)

    }

    override fun onBindItemClickListener(itemView: View, position: Int, bean: CategoryEntity) {

    }


}

class MoreViewHolder(itemView: View) : BaseViewHolder<CategoryEntity>(itemView) {

    private lateinit var mAcbTab: AppCompatCheckBox

    override fun findView(itemView: View) {
        mAcbTab=  itemView.findViewById(R.id.acb_tab)
    }

    override fun bindTo(bean: CategoryEntity) {
        mAcbTab.apply {
            text=bean.title
            isChecked=bean.isSelected
        }
    }

}