package com.aurora.common.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.aurora.common.R

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/28 11:04
 * @version: 2.0
 */
class MainAdapter(mList: ArrayList<String>) : SimpleBaseAdapter<String, MainViewHolder>(mList) {

    override fun initViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)

    }
    override fun onBindItemClickListener(itemView: View, position: Int, bean: String) {

    }
}

class MainViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    private lateinit var mAtvContent: AppCompatTextView
    override fun findView(itemView: View) {
        mAtvContent = itemView.findViewById(R.id.atv_content)

    }

    override fun bindTo(t: String) {
        mAtvContent.text = t
    }

}