package com.cherish.common.widget.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cherish.common.R

/**
 * @author: cherish
 * @description: 弹出框
 * @date: 2019/5/27 16:46
 * @version: 2.0
 */

class LottieDialogFragment: DialogFragment() {
    companion object {
        val TAG = "LottieDialogFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.LottieLoadingDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_lottie_loading, container, false)
    }
}