package com.aurora.common.widget.dialog

import android.view.View
import com.aurora.common.R

/**
 * @author: aurora
 * @description: 分享弹出框
 * @date: 2019/5/29 14:45
 * @version: 2.0
 */
class ShareDialogFragment(list: ArrayList<String>, override var TAG: String="ShareDialogFragment") : BaseDialogFragment<String>(list) {

    override fun setLayoutId()=R.layout.dialog_share

    override fun bindSource(view: View?, list: ArrayList<String>) {

    }

    override fun bindListener(view: View?) {
    }

}