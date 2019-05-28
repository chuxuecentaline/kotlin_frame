package com.cherish.centre.ui

import com.cherish.common.entity.ParamsHelper

/**
 * @author: cherish
 * @description: Main 参数
 * @date: 2019/5/28 11:34
 * @version: 2.0
 */
class MainParamsHelper : ParamsHelper<ArrayList<String>>(arrayListOf()) {
    init {
        resource = arrayListOf("钱包", "设置", "消息", "服务端管理", "供应端管理", "我的订单", "我的收藏", "我要充值", "充值明细", "消费明细", "权益凭证", "我的发票", "审核商品", "审核供应端", "销售补助", "产品授信管理", "晒图", "签到","自营店","健康优选代理商专享区","现金购买服务端拿收益")
    }
}