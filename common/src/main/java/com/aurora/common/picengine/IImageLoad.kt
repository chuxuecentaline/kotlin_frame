package com.aurora.common.picengine

import android.widget.ImageView
import com.aurora.common.R

/**
 * @author: aurora
 * @description: 图片加载的方式
 * @date: 2019/5/10 14:22
 * @version: 2.0
 */
interface IImageLoad<E>  {
    /**
     * @param circleCrop 是否加载圆形图片
     * @param crossFade 是否使用加载过度动画
     */
    fun  load(
            view: ImageView,
            source: E?,
            placeholder: Int = R.drawable.ic_placeholder,
            error: Int = R.drawable.ic_placeholder,
            fallback: Int = R.drawable.ic_placeholder,
            circleCrop: Boolean = false,
            crossFade: Boolean = true
    )
}