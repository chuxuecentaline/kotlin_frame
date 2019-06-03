package com.aurora.common.spreadfun

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

/**
 * @author: aurora
 * @description:软键盘开启、关闭
 * @date: 2019/5/31 11:57
 * @version: 2.0
 */

fun AppCompatActivity.controlKeyboard(isShow: Boolean) {
    try {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager ?: return
        if (isShow) {
            if (currentFocus != null) {
                //有焦点打开
                imm.showSoftInput(currentFocus, 0)
            } else {
                //无焦点打开
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        } else {
            if (currentFocus != null) {
                //有焦点关闭
                imm.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
            } else {
                //无焦点关闭
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}