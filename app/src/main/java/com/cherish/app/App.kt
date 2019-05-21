package com.cherish.app

import android.app.Application

import com.cherish.common.api.ApiCreate
import com.cherish.common.utils.ToastUtil
import com.squareup.leakcanary.LeakCanary
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import android.R
import android.R.attr.colorPrimary
import android.content.Context
import com.scwang.smartrefresh.layout.api.RefreshHeader
import android.R.attr.colorPrimary
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.common.BaseApplication
import com.cherish.common.room.AppDataBase

/**
 * @author: cherish
 * @description: 首页
 * @date: 2019/5/8 16:09
 * @version: 2.0
 */
class App : BaseApplication() {
    override fun initConfigure(debugMode: Boolean) {
        if (debugMode) {
            LeakCanary.install(this)
        }

    }


}
