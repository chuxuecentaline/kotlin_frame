package com.cherish.square.ui

import com.cherish.common.entity.ParamsHelper

/**
 * @author: cherish
 * @description: Main 参数
 * @date: 2019/5/28 11:34
 * @version: 2.0
 */
class MainParamsHelper : ParamsHelper<ArrayList<String>>(arrayListOf()) {
    init {
        resource = arrayListOf("健康优选专区", "健康优选专区订货", "信息合约管理")
    }
}