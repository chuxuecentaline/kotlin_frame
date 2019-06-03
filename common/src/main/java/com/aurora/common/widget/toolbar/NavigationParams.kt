package com.aurora.common.widget.toolbar

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

/**
 * @author: aurora
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