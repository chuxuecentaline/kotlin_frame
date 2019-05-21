package com.cherish.common.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {
    /**
     * 订阅管理
     */
    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    private lateinit var mViewModel: BaseViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(setLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initConfigure(view)
        bindLiveData()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(requireActivity()).get(BaseViewModel::class.java)

    }

    /**
     * 管理订阅
     */
    protected fun compositeDisposable() = compositeDisposable

    /**
     * 设置布局
     */
    abstract fun setLayoutId(): Int

    /**
     * 初始化配置
     */
    abstract fun initConfigure(view: View?)

    /**
     * 绑定life
     */
    abstract fun bindLiveData()

    override fun onDestroyView() {
        compositeDisposable.clear()
        super.onDestroyView()
    }
}
