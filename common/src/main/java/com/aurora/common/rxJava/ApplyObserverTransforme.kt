package com.aurora.common.rxJava

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author: aurora
 * @description:线程切换
 * @date: 2019/5/8 16:21
 * @version: 2.0
 */
object ApplyObserverTransform {
    fun <T> compose(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}