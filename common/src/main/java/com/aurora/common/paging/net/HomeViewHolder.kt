package com.aurora.system.Home

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.aurora.common.R
import com.aurora.common.entity.HomeEntity
import com.aurora.common.recycler.BaseViewHolder

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/8 14:45
 * @version: 2.0
 */
class HomeViewHolder(itemView: View) : BaseViewHolder<HomeEntity>(itemView) {
    open lateinit var atv_content: AppCompatTextView

    override fun findView(itemView: View) {
        atv_content = itemView.findViewById(R.id.atv_content)
    }

    override fun bindTo(t: HomeEntity) {
        t?.let {
            atv_content.text=t.login
        }

    }


}