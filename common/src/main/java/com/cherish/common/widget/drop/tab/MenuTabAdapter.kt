package com.cherish.common.widget.drop.tab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.cherish.common.R
import com.cherish.common.recycler.BaseViewHolder
import com.cherish.common.recycler.SimpleBaseAdapter
import com.cherish.common.widget.tint

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/30 14:00
 * @version: 2.0
 */
class MenuTabAdapter : SimpleBaseAdapter<TabMenuEntity, MenuTabViewHolder>(arrayListOf()) {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): MenuTabViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tab, parent, false)
        return MenuTabViewHolder(view)
    }

    override fun onBindItemClickListener(itemView: View, position: Int, bean: TabMenuEntity) {

    }
}

class MenuTabViewHolder(view: View) : BaseViewHolder<TabMenuEntity>(view) {

    private lateinit var mAtvTitle: AppCompatTextView
    private lateinit var mIvRight: AppCompatImageView

    override fun findView(itemView: View) {

        mAtvTitle = itemView.findViewById(R.id.atv_title)
        mIvRight = itemView.findViewById(R.id.iv_right)
    }

    override fun bindTo(bean: TabMenuEntity) {

        mAtvTitle.text = bean.title
        bean.icon?.let { mIvRight.setBackgroundResource(it) }
        if (bean.isSelect) {
            mAtvTitle.setTextColor(color(R.color.colorAccent))
            mIvRight.tint(mIvRight, R.drawable.ic_arrow_drop_down_black, color(R.color.colorAccent))
        } else {
            mAtvTitle.setTextColor(color(R.color.color_333333))
            mIvRight.tint(mIvRight, R.drawable.ic_arrow_drop_down_black, color(R.color.color_333333))
        }
    }

}