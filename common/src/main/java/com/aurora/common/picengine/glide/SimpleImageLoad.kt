package com.aurora.common.picengine.glide

import android.content.Context
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.aurora.common.picengine.IImageLoad

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/10 14:36
 * @version: 2.0
 */
class SimpleImageLoad<E> : IImageLoad<E> {
    private var glide: RequestManager
    private var options: RequestOptions

    constructor(content: FragmentActivity) {
        glide = Glide.with(content)
        options = RequestOptions()
    }

    constructor(content: AppCompatActivity) {
        glide = Glide.with(content)
        options = RequestOptions()
    }

    constructor(content: Context) {
        glide = Glide.with(content)
        options = RequestOptions()
    }
    override fun load(view: ImageView, source: E?, placeholder: Int, error: Int, fallback: Int, circleCrop: Boolean, crossFade: Boolean) {
        var options = when {
            circleCrop -> {
                options.autoClone()
                        .placeholder(placeholder)
                        .error(error)
                        .fallback(fallback)
                        .transform(CircleCrop())
            }
            else -> {
                options.autoClone()
                        .placeholder(placeholder)
                        .error(error)
                        .fallback(fallback)
            }
        }
        when {
            crossFade -> {
                glide.load(source)
                        .apply(options)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(view)
            }
            else -> {
                glide.load(source)
                        .apply(options)
                        .into(view)
            }
        }

    }
}