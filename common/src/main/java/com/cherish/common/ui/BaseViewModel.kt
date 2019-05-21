package com.cherish.common.ui

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    /**
     * 管理订阅
     */
    private val compositeDisposable by lazy {
        CompositeDisposable()
    }

    protected fun compositeDisposable() = compositeDisposable
    fun addDisposable(d: Disposable) {
        compositeDisposable.add(d)
    }

    /**
     * clean 订阅
     */
    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}
