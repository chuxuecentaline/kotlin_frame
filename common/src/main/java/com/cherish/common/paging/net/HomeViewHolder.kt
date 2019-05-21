package com.cherish.app.Home

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.cherish.common.R
import com.cherish.common.entity.HomeEntity
import com.cherish.common.recycler.BaseViewHolder

/**
 * @author: cherish
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