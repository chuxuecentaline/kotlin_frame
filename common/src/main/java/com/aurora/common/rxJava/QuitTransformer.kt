package com.aurora.common.rxJava

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * @author: aurora
 * @description: 退出
 * @date: 2019/5/29 18:03
 * @version: 2.0
 */
class QuitTransformer<T>(var observable: Observable<*>) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.takeUntil(observable)
    }
}