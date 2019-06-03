package com.aurora.common.rxJava

import com.aurora.common.entity.ResponseEntity
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/8 16:28
 * @version: 2.0
 */
abstract class OnRequestNext<R>(private val compositeDisposable: CompositeDisposable? = null) : Observer<ResponseEntity<R>> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        compositeDisposable?.add(d)
    }

    override fun onNext(response: ResponseEntity<R>) {
        when (response.success) {
            true -> when {
                response.obj == null -> fail(ApiThrowable(response.code, "Response.content is null"))
                else -> success(response.obj)
            }
            else -> fail(ApiThrowable(response.code, response.msg))
        }

    }

    override fun onError(e: Throwable) {
        fail(ApiThrowable(404, e.message))
    }

    /**
     * 请求成功
     */
    abstract fun success(t: R)

    /**
     * 网络异常
     */
    abstract fun fail(apiThrowable: ApiThrowable)
}