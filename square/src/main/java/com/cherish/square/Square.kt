package com.cherish.square

import com.cherish.common.BaseApplication
import com.squareup.leakcanary.LeakCanary

/**
 * @author: cherish
 * @description: 合约广场
 * @date: 2019/5/21 11:21
 * @version: 2.0
 */
class Square : BaseApplication() {
    override fun initConfigure(debugMode: Boolean) {
        if(debugMode){
            LeakCanary.install(this)
        }
    }


}