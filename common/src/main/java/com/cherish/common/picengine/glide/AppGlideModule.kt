package com.cherish.common.picengine.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import java.io.InputStream


/**
 *
 * @author: cherish
 * @description: AppGlideModule
 * @date: 2019/5/27 15:20
 * @version: 2.0
 */
@GlideModule
class SysGlideModule  : AppGlideModule() {
    /**
     * isManifestParsingEnabled设置清单解析，设置为false，避免添加相同的模块两次
     */
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }

    /**
     * 1，设置手机默认推荐缓存大小.MemorySizeCalculator类通过考虑设备给定的可用内存和屏幕大小想出合理的默认大小。
     */
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDiskCache(ExternalPreferredCacheDiskCacheFactory(context, 209715200L))
        builder.setDefaultRequestOptions(
                RequestOptions()
                        .format(DecodeFormat.PREFER_ARGB_8888)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
        )
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(
                GlideUrl::class.java,
                InputStream::class.java,
                OkHttpUrlLoader.Factory(OkHttpClient4Glide.okHttpClient)
        )
    }
}