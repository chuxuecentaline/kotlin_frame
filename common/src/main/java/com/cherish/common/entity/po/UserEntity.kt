package com.cherish.common.entity.po

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author: cherish
 * @description:
 * @date: 2019/5/20 15:58
 * @version: 2.0
 */
@Entity(tableName = "user")
data class UserEntity(@PrimaryKey @ColumnInfo(name = "id") var id: Int,  @ColumnInfo(name = "json_value") var jsonValue: String?)