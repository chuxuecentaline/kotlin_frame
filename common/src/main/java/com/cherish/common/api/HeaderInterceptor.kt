package com.cherish.common.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: cherish
 * @description: 公共参数
 * @date: 2019/5/10 10:38
 * @version: 2.0
 */
class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        builder.addHeader("platform", "android")
        return chain.proceed(builder.build())
    }
}