package com.cherish.app.ui.search

import com.cherish.app.R
import com.cherish.common.widget.drop.MenuEntity
import com.cherish.common.widget.drop.tab.TabMenuEntity

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/30 16:02
 * @version: 2.0
 */
class SearchParamsHelper {

    val resource = arrayListOf(TabMenuEntity("综合排序", R.drawable.ic_arrow_drop_down_black, true),
            TabMenuEntity("销量优先"),
            TabMenuEntity("列表", R.drawable.ic_arrow_drop_down_black),
            TabMenuEntity("筛选", R.drawable.ic_arrow_drop_down_black))

    var list = arrayListOf(MenuEntity(1, "综合排序", true),
            MenuEntity(2, "价格升序"),
            MenuEntity(3, "价格降序"),
            MenuEntity(4, "好评数"),
            MenuEntity(5, "新品上架时间"),
            MenuEntity(6, "销量")
    )

    var more = arrayListOf(MenuEntity(1, "服装", true),
            MenuEntity(2, "箱包"),
            MenuEntity(3, "家电"),
            MenuEntity(4, "鞋子"),
            MenuEntity(5, "珠宝首饰"),
            MenuEntity(6, "百货"),
            MenuEntity(7, "图书乐器"),
            MenuEntity(11, "服装"),
            MenuEntity(12, "箱包"),
            MenuEntity(13, "家电"),
            MenuEntity(14, "鞋子"),
            MenuEntity(15, "珠宝首饰"),
            MenuEntity(16, "百货"),
            MenuEntity(17, "图书乐器")

    )
}