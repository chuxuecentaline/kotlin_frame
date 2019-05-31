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
        resource = arrayListOf("商品信息合约列表", "普通信息合约列表", "信息合约管理","服务端信息合约管理")
    }
}