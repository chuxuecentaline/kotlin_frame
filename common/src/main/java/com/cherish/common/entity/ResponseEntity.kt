package com.cherish.common.entity

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/10 15:18
 * @version: 2.0
 */
class ResponseEntity<T>(val obj: T, val msg: String, val code: Int=200, val success: Boolean)