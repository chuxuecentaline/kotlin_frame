package com.cherish.common.entity


/**
 * @author: cherish
 * @description:
 * @date: 2019/5/17 13:05
 * @version: 2.0
 */

data class ListEntity(
        val list: List<ListData>

)
data class ListData(
        val activeId: Int,
        val businessId: String,
        val createTime: String,
        val deductiblePrice: Double,
        val downpayment: Int,
        val giveNumber: Int,
        val id: String,
        val isAdvance: Double,
        val isRate: Double,
        val isRecommend: Int,
        val isRemind: Int,
        val isSpecial: Double,
        val isUabRate: Int,
        val isUse: Int,
        val marketPrice: Double,
        val orderGoodsPrice: Double,
        val paymentBeginTime: String,
        val paymentEndTime: String,
        val produceType: Int,
        val productClassId: Int,
        val productSubsidyQuantity: Int,
        val remindNumber: Int,
        val residualQuantity: Int,
        val returnUab: Int,
        val sales: Int,
        val shopId: String,
        val shopName: String,
        val shopType: Int,
        val specialEndTime: String,
        val specialSellEndTime: String,
        val specialSellPrice: Double,
        val specialSellStartTime: String,
        val specialStartTime: String,
        val spikePrice: Double,
        val subsidyQuantity: Int,
        val thumbnail: String,
        val title: String
)
