package com.aurora.common

import android.app.Application
import android.content.res.Configuration
import android.content.res.Resources
import com.alibaba.android.arouter.launcher.ARouter
import com.aurora.common.api.ApiCreate
import com.aurora.common.picengine.glide.OkHttpClient4Glide
import com.aurora.common.room.AppDataBase
import com.aurora.common.utils.SharePreUtils
import com.aurora.common.utils.ToastUtil
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits

/**
 * @author: aurora
 * @description:Application 基类 初始化一些公有的配置
 * @date: 2019/5/21 11:13
 * @version: 2.0
 */
abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /**
         * 网络请求
         */
        ApiCreate.init(this, BuildConfig.DEBUG)
        /**
         * toast
         */
        ToastUtil.init(this)
        /**
         * SharedPreferences
         */
        SharePreUtils.init(this)
        /**
         * 数据库
         */
        AppDataBase.init(this)
        /**
         * ARouter 组建化模块跳转
         */
        if (debugMode()) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog()        // Print log
            ARouter.openDebug()      // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is asecurity risk)
        }
        ARouter.init(this)
        OkHttpClient4Glide.init()
        initConfigure(debugMode())
        initAutoSize()
    }

    /**
     * 模块单独的配置
     */
    abstract fun initConfigure(debugMode: Boolean)

    private fun debugMode() = BuildConfig.DEBUG
    /**
     * 自动适配
     */
    private fun initAutoSize() {
        AutoSizeConfig.getInstance()
                .setBaseOnWidth(true)
                .unitsManager
                .setSupportDP(false)
                .setSupportSP(false)
                .supportSubunits = Subunits.MM
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        if (newConfig?.fontScale != 1.toFloat())//非默认值
            resources
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        val res = super.getResources()
        if (res.configuration.fontScale != 1.toFloat()) {//非默认值
            val newConfig = Configuration()
            newConfig.setToDefaults()//设置默认值
            res.updateConfiguration(newConfig, res.displayMetrics)
        }
        return res
    }


}