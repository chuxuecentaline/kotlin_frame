package com.aurora.common.entity

import com.squareup.moshi.JsonClass

/**
 * @author: aurora
 * @description: Response基类
 * @date: 2019/5/10 15:18
 * @version: 2.0
 */
@JsonClass(generateAdapter = true)
data class ResponseEntity<T>(val obj: T?, val msg: String, val code: Int?=200, val success: Boolean)