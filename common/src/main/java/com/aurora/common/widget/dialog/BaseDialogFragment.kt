package com.aurora.common.widget.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.aurora.common.R

/**
 * @author: aurora
 * @description: dialogFragment 基类
 * @date: 2019/5/29 15:12
 * @version: 2.0
 */
interface DialogCallBack<T> {
    fun onClick(view: View, bean: T)
}

abstract class BaseDialogFragment<T>(var list: ArrayList<T>) : DialogFragment() {

    abstract var TAG: String
    lateinit var mListener: DialogCallBack<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.LottieLoadingDialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(setLayoutId(), container, false)
        bindSource(view, list)
        bindListener(view)
        return view
    }

    /**
     * 设置布局
     */
    abstract fun setLayoutId(): Int

    /**
     * 绑定参数
     */
    abstract fun bindSource(view: View?, list: ArrayList<T>)

    /**
     * 绑定事件
     */
    abstract fun bindListener(view: View?)

    /**
     * 设置回调事件
     */
    fun setOnClickListener(listener: DialogCallBack<T>) {
        mListener = listener
    }

}