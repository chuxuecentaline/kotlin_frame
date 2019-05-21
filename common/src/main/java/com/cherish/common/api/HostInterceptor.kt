package com.cherish.common.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author: cherish
 * @description: 请求头拦截器
 * @date: 2019/5/10 11:19
 * @version: 2.0
 */
class HostInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder()
        val headerValues = request.headers(RequestHeader.HEADER)
        var newBaseUrl: HttpUrl? = null
        if (headerValues.isNotEmpty()) {
            when {
                headerValues.contains(RequestHeader.HEADER_PAGING) -> newBaseUrl = HttpUrl.parse(ApiConfig.pagingUrl)
            }
            builder.removeHeader(RequestHeader.HEADER)
        }
        return if (newBaseUrl == null) {
            chain.proceed(builder.build())
        } else {
            val httpUrlBuild = newBaseUrl.newBuilder()
            val pathSegments = request.url().pathSegments()
            pathSegments.forEachIndexed { _, s ->
                httpUrlBuild.addPathSegment(s)
            }
            httpUrlBuild.encodedQuery(request.url().encodedQuery())
            chain.proceed(builder.url(httpUrlBuild.build()).build())

        }
    }
}