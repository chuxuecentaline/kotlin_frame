package com.cherish.app.provider
import com.cherish.app.BuildConfig
import com.zhihu.matisse.internal.entity.CaptureStrategy
import java.util.*

/**
 *
 * @author: cherish
 * @description: AppCaptureStrategy
 * @date: 2019/5/27 15:20
 * @version: 2.0
*/
class AppCaptureStrategy(isPublic: Boolean) : CaptureStrategy(
    isPublic, String.format(Locale.CHINA, "${BuildConfig.APPLICATION_ID}.fileProvider")
)