package com.cherish.common.room.annotation

import androidx.annotation.IntDef
import com.cherish.common.room.annotation.DaoType.Companion.ADD
import com.cherish.common.room.annotation.DaoType.Companion.DELETE
import com.cherish.common.room.annotation.DaoType.Companion.UPDATE

/**
 * @author: cherish
 * @description: 数据操作方式
 * @date: 2019/5/20 15:52
 * @version: 2.0
 */
@IntDef(ADD, DELETE, UPDATE)
@Retention(AnnotationRetention.SOURCE)
annotation class DaoType {
    companion object {
        const val ADD = 0
        const val DELETE = 1
        const val UPDATE = 2
    }

}