package com.aurora.common.spreadfun

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_toolbar.*

/**
 * @author: aurora
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