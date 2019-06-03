package com.aurora.common.widget.toolbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.jaeger.library.StatusBarUtil

/**
 * @author: aurora
 * @description: 标题栏
 * @date: 2019/5/21 17:06
 * @version: 2.0
 */
abstract class AbsNavigationBar<P : NavigationParams>(var params: P) : NavigationBarImpl<P> {

    lateinit var activityRoot: ViewGroup
    lateinit var parent: ViewGroup
    private lateinit var mView: View

    //1. 布局
    init {
        bindView()

    }

    private fun bindView() {
        params.let {
            activityRoot = params.getActivity().window.decorView as ViewGroup
            parent = params.getParent()
            if (parent == null) {
                parent = activityRoot.getChildAt(0) as ViewGroup

            }
            mView = LayoutInflater.from(params.getActivity()).inflate(bindLayoutId(), parent, false)
            parent.addView(mView, 0)
            //2 绑定数据
            applyParams(mView)
            //3 点击事件
            navigationCallback(mView, params)

        }


    }

    /**
     * 设置主题
     */
    fun setThemeMode(light: Boolean) {
        if (light) {
            StatusBarUtil.setLightMode(params.getActivity())
        } else {
            StatusBarUtil.setDarkMode(params.getActivity())
        }

    }

    /**
     * 设置状态栏颜色
     */
    fun setStatusColor(color: Int) {
        StatusBarUtil.setColor(params.getActivity(), color, 0)
    }

    /**
     * 设置标题颜色
     */
    fun setTitleColor(color: Int, atv_title: AppCompatTextView) {
        atv_title.setTextColor(color)
    }
    /**
     * Set status bar translucent
     */
    fun setTranslucent() {
        StatusBarUtil.setTranslucent(params.getActivity())
    }

    open class Build(val activity: AppCompatActivity) {
        private lateinit var mActivity: AppCompatActivity
        fun setActivity() {
            mActivity = activity
        }


    }


}