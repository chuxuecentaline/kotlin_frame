package com.aurora.common.spreadfun

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * @author: aurora
 * @description: 文本编辑
 * @date: 2019/5/31 17:18
 * @version: 2.0
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}