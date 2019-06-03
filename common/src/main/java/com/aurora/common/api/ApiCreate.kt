package com.aurora.common.api


import android.content.Context
import com.aurora.common.BuildConfig

import java.util.concurrent.TimeUnit

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Api创建
 *
 * @author shengl
 */

class ApiCreate private constructor(context: Context, debug: Boolean) {
    private val mBuilder: Retrofit.Builder

    init {
        val builder = OkHttpClient.Builder()
                .connectTimeout(BuildConfig.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(BuildConfig.READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .cache(Cache(context.cacheDir, 100 * 1024 * 1024L))
                .addInterceptor(HeaderInterceptor())
                .addInterceptor(HostInterceptor())

        if (debug) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpLoggingInterceptor)
        }

        mBuilder = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
    }

    companion object {

        private var sApiCreate: ApiCreate? = null

        /**
         * 初始化
         */
        @JvmStatic
        fun init(context: Context, debug: Boolean) {
            if (sApiCreate == null) {
                sApiCreate = ApiCreate(context, debug)
            }
        }

        /**
         * 创建
         */
        @JvmStatic
        fun <T> create(clazz: Class<T>): T {
            return sApiCreate!!.mBuilder.build().create(clazz)
        }

    }
}