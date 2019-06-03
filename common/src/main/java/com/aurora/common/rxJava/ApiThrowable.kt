package com.aurora.common.rxJava

/**
 * @author: aurora
 * @description:
 * @date: 2019/5/10 16:09
 * @version: 2.0
 */
class ApiThrowable(val code: Int?=200, message: String? = "") : Throwable(message)