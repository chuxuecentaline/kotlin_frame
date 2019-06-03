package com.cherish.common.widget.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cherish.common.R

/**
 * @author: cherish
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