package com.cherish.app.login

import android.content.Context
import com.alibaba.android.arouter.exception.HandlerException
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.cherish.common.utils.IntentExtra

/**
 * @author: cherish
 * @description:拦截器 必须登录成功之后才能进入的页面
 * @date: 2019/5/27 8:45
 * @version: 2.0
 */
@Interceptor(priority = 1,name = IntentExtra.LOGIN_INTERCEPTOR)
class LoginInterceptor:IInterceptor {
    lateinit var mContext:Context

    override fun init(context: Context?) {
        mContext= context!!
    }
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if(postcard?.path == IntentExtra.CART){// 购物车必须先登录
            ARouter.getInstance().build(IntentExtra.LOGIN).navigation(mContext)
            callback?.onInterrupt(HandlerException("must be login"))
        }else{
            // No problem! hand over control to the framework
            callback?.onContinue(postcard)
        }

    }


}