package com.cherish.common.ui.login

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.cherish.common.utils.IntentExtra

/**
 * @author: cherish
 * @description:登录拦截器
 * @date: 2019/5/27 8:45
 * @version: 2.0
 */
@Interceptor(priority = 1,name = IntentExtra.LOGIN_INTERCEPTOR)
class LoginInterceptor:IInterceptor {
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        // No problem! hand over control to the framework
        callback?.onContinue(postcard)
    }

    override fun init(context: Context?) {
    }
}