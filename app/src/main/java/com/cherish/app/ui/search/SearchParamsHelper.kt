package com.cherish.app.ui.search

import com.cherish.app.R
import com.cherish.common.entity.ParamsHelper
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
            TabMenuEntity("综合排序", R.drawable.ic_arrow_drop_down_black),
            TabMenuEntity("综合排序", R.drawable.ic_arrow_drop_down_black))

    var list = arrayListOf(MenuEntity(1, "综合排序", true),
            MenuEntity(2, "价格升序"),
            MenuEntity(3, "价格降序"),
            MenuEntity(4, "好评数"),
            MenuEntity(5, "新品上架时间"),
            MenuEntity(6, "销量")
    )
}