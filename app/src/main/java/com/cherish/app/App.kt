package com.cherish.app

import com.cherish.common.BaseApplication
import com.squareup.leakcanary.LeakCanary
import com.taobao.sophix.SophixManager
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

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

    override fun onCreate() {
        super.onCreate()
        try {
            SophixManager.getInstance().queryAndLoadNewPatch()
        }catch (e:Exception){
        }


    }


}
