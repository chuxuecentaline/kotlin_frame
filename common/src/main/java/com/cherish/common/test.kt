package com.cherish.common

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.cherish.common.widget.g

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/17 17:26
 * @version: 2.0
 */
class test : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dg = dg().sayHallo()

    }
}
