package com.aurora.common.spreadfun

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

/**
 * @author: aurora
 * @description: 图片着色
 * @date: 2019/5/30 14:27
 * @version: 2.0
 */
fun AppCompatImageView.tint(imageView: AppCompatImageView?, @DrawableRes icon: Int, @ColorInt color: Int) {
    val drawable = ContextCompat.getDrawable(context, icon)
    drawable?.let { DrawableCompat.setTint(it, color) }
    imageView?.setImageDrawable(drawable)

}
