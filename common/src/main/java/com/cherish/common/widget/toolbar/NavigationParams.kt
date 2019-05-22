package com.cherish.common.widget.toolbar

import android.view.ViewGroup
import android.view.ViewParent
import androidx.appcompat.app.AppCompatActivity

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/21 17:18
 * @version: 2.0
 */
open class NavigationParams(private var parent: ViewGroup) {
    private lateinit var mActivity: AppCompatActivity

   fun setActivity(activity: AppCompatActivity){
       mActivity=activity
   }

    fun getActivity() = mActivity
    fun getParent() = parent

}