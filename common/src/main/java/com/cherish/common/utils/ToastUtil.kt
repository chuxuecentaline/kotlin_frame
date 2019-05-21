package com.cherish.common.utils

import android.content.Context
import android.widget.Toast
import com.cherish.common.ui.BaseActivity.Companion.mContext

/**
 * @author: cherish
 * @description: toast 工具类
 * @date: 2019/5/20 9:52
 * @version: 2.0
 */
class ToastUtil {
    companion object {
        private lateinit var mContext: Context
        fun init(context: Context) {
            mContext = context
        }

        open fun short(tip: String) {
            Toast.makeText(mContext, tip, Toast.LENGTH_SHORT)
                    .show()
        }

        open fun long(tip: String) {
            Toast.makeText(mContext, tip, Toast.LENGTH_LONG).show()
        }
    }


}