package com.cherish.common.widget.toolbar.normal

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build.VERSION_CODES.P
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import com.cherish.common.R
import com.cherish.common.widget.toolbar.AbsNavigationBar
import com.jaeger.library.StatusBarUtil

/**
 * @author: cherish
 * @description: 普通 toolBar
 * @date: 2019/5/22 10:20
 * @version: 2.0
 */
class NormalNavigationBar(params: NormalNavigationParams? = null) : AbsNavigationBar<NormalNavigationParams>(params!!) {

    override fun bindLayoutId() = R.layout.layout_toolbar

    override fun applyParams(view: View) {
        val mToolbar = view.findViewById<Toolbar>(R.id.toolbar)
        params.getActivity().setSupportActionBar(mToolbar)
        params.getActivity().supportActionBar.apply {
            this?.setDisplayHomeAsUpEnabled(params.mShow)
            this?.setHomeButtonEnabled(params.mShow)
        }
        params.mBackResId?.let { mToolbar.setNavigationIcon(it) }
        val atv_title = view.findViewById<AppCompatTextView>(R.id.atv_title)
        atv_title.apply {
            text = params.mTitle
        }
        setTranslucent()
        setTitleColor(params.mTitleColor, atv_title)
        setStatusColor(params.mColor)
        mToolbar.setBackgroundResource(params.mBackgroundColor)
        setThemeMode(params.mLight)

    }

    override fun navigationCallback(view: View, params: NormalNavigationParams) {

    }

    open class Build(activity: AppCompatActivity) : AbsNavigationBar.Build(activity) {
        lateinit var params: NormalNavigationParams

        constructor(activity: AppCompatActivity, parent: ViewGroup) : this(activity) {
            params = NormalNavigationParams(parent)
            params.setActivity(activity)
        }

        /**
         * 设置返回图片
         */
        fun setBackIcon(resId: Int): Build {
            params.mBackResId = resId
            return this

        }

        /**
         * 设置标题
         */
        fun setTitle(title: String): Build {
            params.mTitle = title
            return this
        }

        /**
         * 设置标题颜色
         */
        fun setTitleColor(color: Int): Build {
            params.mTitleColor = color
            return this
        }

        /**
         * 设置主题
         */
        fun setThemeMode(light: Boolean): Build {
            params.mLight = light
            return this
        }

        /**
         * 是否显示返回键
         */
        fun showHomeAsUp(show: Boolean): Build {
            params.mShow = show
            return this
        }

        /**
         * 设置状态栏的颜色
         */
        fun setStatusColor(color: Int): Build {
            params.mColor = color
            return this
        }

        /**
         * 设置状态栏透明
         */
        fun setTranslucent(isTranslucent: Boolean): Build {
            params.mIsTranslucent = isTranslucent
            return this
        }

        /**
         * 设置toolBar 背景色
         */
        fun setBackgroundColor(color: Int): Build {
            params.mBackgroundColor = color
            return this
        }

        fun create(): NormalNavigationBar {
            return NormalNavigationBar(params)
        }


    }


}