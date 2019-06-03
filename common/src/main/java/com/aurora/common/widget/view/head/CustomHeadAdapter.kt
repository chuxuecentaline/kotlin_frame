package com.aurora.common.widget.view.head

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.aurora.common.R
import com.aurora.common.picengine.glide.SimpleImageLoad
import com.aurora.common.recycler.BaseViewHolder
import com.aurora.common.recycler.SimpleBaseAdapter

/**
 * @author: aurora
 * @description: 头部适配器
 * @date: 2019/5/23 14:20
 * @version: 2.0
 */
class CustomHeadAdapter(data: ArrayList<String>) : SimpleBaseAdapter<String, CustomHeadViewHolder>(data) {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): CustomHeadViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image, parent, false)
        return CustomHeadViewHolder(view)
    }

    override fun onBindItemClickListener(itemView: View, position: Int, bean: String) {
    }

}

class CustomHeadViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {

    private lateinit var ivBanner: ImageView
    override fun findView(itemView: View) {
        ivBanner = itemView.findViewById(R.id.iv_banner)
    }

    override fun bindTo(url: String) {
        SimpleImageLoad<String>(itemView.context).load(ivBanner, url)
    }

}