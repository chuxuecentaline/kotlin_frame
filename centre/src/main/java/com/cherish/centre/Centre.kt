package com.cherish.centre

import com.cherish.common.BaseApplication
import com.squareup.leakcanary.LeakCanary

/**
 * @author: cherish
 * @description: 配置中心
 * @date: 2019/5/21 11:19
 * @version: 2.0
 */
class Centre: BaseApplication() {
    override fun initConfigure(debugMode: Boolean) {
        if(debugMode){
            LeakCanary.install(this)
        }
    }


}