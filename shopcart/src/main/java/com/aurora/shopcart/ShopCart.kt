package com.aurora.shopcart

import com.aurora.common.BaseApplication
import com.squareup.leakcanary.LeakCanary

/**
 * @author: aurora
 * @description: 购物车
 * @date: 2019/5/21 11:20
 * @version: 2.0
 */
class ShopCart : BaseApplication() {
    override fun initConfigure(debugMode: Boolean) {
        if(debugMode){
            LeakCanary.install(this)
        }
    }


}
