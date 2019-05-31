package com.cherish.app.login

import android.content.Context
import com.alibaba.android.arouter.exception.HandlerException
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.common.utils.IntentExtra
import com.cherish.common.utils.SharePreUtils

/**
 * @author: cherish
 * @description:拦截器 必须登录成功之后才能进入的页面
 * @date: 2019/5/27 8:45
 * @version: 2.0
 * fix me 测试拦截，开发按需修改
 */
@Interceptor(priority = 1, name = IntentExtra.Arouter.LOGIN_INTERCEPTOR)
class LoginInterceptor : IInterceptor {

    private  var mContext: Context?=null

    override fun init(context: Context?) {
        mContext = context
    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {

        val loginState = SharePreUtils.getBoolean(IntentExtra.SP.LOGIN_STATUS)
        if (postcard?.path == IntentExtra.Arouter.CART) {// 购物车必须先登录
            if (!loginState) {
                callback?.onInterrupt(null)
            } else {
                callback?.onContinue(postcard)
            }

        } else {
            // No problem! hand over control to the framework
            callback?.onContinue(postcard)
        }

    }


}