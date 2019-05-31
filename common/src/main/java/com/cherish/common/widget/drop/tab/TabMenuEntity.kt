package com.cherish.common.widget.drop.tab

import androidx.annotation.DrawableRes

/**
 * @author: cherish
 * @description:tab 实体类 包含 文字 图标 选中
 * @date: 2019/5/30 14:06
 * @version: 2.0
 */
data class TabMenuEntity(var title: String, @DrawableRes val icon: Int? = null, var isSelect: Boolean = false)