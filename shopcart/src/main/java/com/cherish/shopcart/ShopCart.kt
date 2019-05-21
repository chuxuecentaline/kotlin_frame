package com.cherish.shopcart

import com.cherish.common.BaseApplication
import com.squareup.leakcanary.LeakCanary

/**
 * @author: cherish
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
