package com.cherish.common.utils

import android.content.Context
import android.widget.Toast

/**
 * @author: cherish
 * @description: toast 工具类 使用 kotlin 扩展函数
 * @date: 2019/5/20 9:52
 * @version: 2.0
 */
class ToastUtil {
    companion object {
        private lateinit var mContext: Context
        fun init(context: Context) {
            mContext = context
        }

        /**
         * toast 内容
         */
        open fun short(tip: String) {
            Toast.makeText(mContext, tip, Toast.LENGTH_SHORT)
                    .show()
        }

        /**
         * 吐司 资源文件 文本
         */
        open fun short(tip: Int) {
            Toast.makeText(mContext, tip, Toast.LENGTH_SHORT)
                    .show()
        }

        /**
         * 长吐司 内容
         */
        open fun long(tip: String) {
            Toast.makeText(mContext, tip, Toast.LENGTH_LONG).show()
        }

        /**
         * 长吐司 资源文件 文本
         */
        open fun long(tip: Int) {
            Toast.makeText(mContext, tip, Toast.LENGTH_LONG).show()
        }
    }


}