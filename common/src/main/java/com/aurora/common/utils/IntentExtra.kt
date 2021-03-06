package com.aurora.common.utils

/**
 * @author: aurora
 * @description: intent 附加的参数名称
 * @date: 2019/5/20 16:35
 * @version: 2.0
 */
object IntentExtra {

    const val DAO_TYPE: String = "DAO_TYPE"
    const val PARAMS: String = "PARAMS"
    const val SUCCESS: String = "SUCCESS"
    const val PATH: String = "PATH"

    /**
     * SharedPreferences 相关
     */
    object SP {
        const val LOGIN_STATUS = "LOGIN_STATUS"
    }

    /**
     * 所有路由相关
     */
    object Arouter {
        /**
         * 管理中心路由path
         */
        const val LOGIN: String = "/centre/LoginActivity"

        /**
         * 合约广场路由path
         */
        const val SCROLLING: String = "/square/ScrollingActivity"

        /**
         * 购物车路由path
         */
        const val CART: String = "/cart/CartActivity"

        /**
         *登录拦截器
         */
        const val LOGIN_INTERCEPTOR: String = "login_interceptor"
    }


}