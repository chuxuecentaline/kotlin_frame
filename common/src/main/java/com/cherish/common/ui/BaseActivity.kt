package com.cherish.common.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {

    /**
     * 管理订阅
     */
    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentId())

        bindData()
        injectListener()
    }


    /**
     * 布局
     */
    abstract fun setContentId(): Int

    /**
     * 绑定数据
     */
    abstract fun bindData()

    /**
     * 事件监听
     */
    abstract fun injectListener()

    /**
     * 管理订阅
     */
    protected fun compositeDisposable() = compositeDisposable

    companion object {
        val mContext = this


    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}
