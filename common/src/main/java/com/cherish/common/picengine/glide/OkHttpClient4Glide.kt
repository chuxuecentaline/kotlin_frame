package com.cherish.common.picengine.glide

import com.cherish.common.BuildConfig
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 *
 * @author: cherish
 * @description: OkHttpClient4Glide
 * @date: 2019/5/27 15:20
 * @version: 2.0
*/
class OkHttpClient4Glide private constructor() {

    companion object {

        lateinit var okHttpClient: OkHttpClient

        fun init() {
            okHttpClient = OkHttpClient.Builder()
                .connectTimeout(BuildConfig.CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(BuildConfig.READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .build()
        }
    }
}