package com.cherish.app.login

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavigationCallback

/**
 * @author: cherish
 * @description: 登录回调 使用包装wrapper 设置模式
 * @date: 2019/5/28 16:23
 * @version: 2.0
 */
abstract class LoginNavigationCallBack : NavigationCallback {
    override fun onLost(postcard: Postcard?) {
    }

    override fun onFound(postcard: Postcard?) {
    }

    override fun onArrival(postcard: Postcard?) {
    }
}