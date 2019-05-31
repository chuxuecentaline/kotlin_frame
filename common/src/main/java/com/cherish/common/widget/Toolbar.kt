package com.cherish.common.widget

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

/**
 * @author: cherish
 * @description: toolBar  配置
 * @date: 2019/5/30 15:59
 * @version: 2.0
 */

fun AppCompatActivity.applyToolBar(){
    setSupportActionBar(toolbar)
    supportActionBar.apply {
        this?.setHomeButtonEnabled(true)
    }
}