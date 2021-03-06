package com.aurora.common.widget.toolbar.normal

import android.graphics.Color
import android.view.ViewGroup
import com.aurora.common.R
import com.aurora.common.widget.toolbar.NavigationParams

/**
 * @author: aurora
 * @description: 参数
 * @date: 2019/5/22 10:20
 * @version: 2.0
 */
class NormalNavigationParams(mParent: ViewGroup,
                             var mBackResId: Int? = null, var mTitle: String? = null,
                             var mLight: Boolean = false, var mShow: Boolean = true,
                             var mColor: Int = Color.GRAY, var mTitleColor: Int = Color.GRAY,
                             var mBackgroundColor: Int = R.color.white, var mIsTranslucent: Boolean = false) : NavigationParams(mParent)