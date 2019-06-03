package com.aurora.shopcart.ui

import com.aurora.common.entity.ParamsHelper

/**
 * @author: aurora
 * @description: Main 参数
 * @date: 2019/5/28 11:34
 * @version: 2.0
 */
class MainParamsHelper : ParamsHelper<ArrayList<String>>(arrayListOf()) {
    init {
        resource = arrayListOf("发票","收货地址","确认订单","支付","健康优选专区", "健康优选专区订货", "代金券")
    }
}