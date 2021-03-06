package com.aurora.common.room.server

import com.aurora.common.entity.po.UserEntity
import com.aurora.common.room.AppDataBase

/**
 * @author: aurora
 * @description: 用户服务
 * @date: 2019/5/20 17:25
 * @version: 2.0
 */
class UserService:AbsServer<UserEntity>("UserService") {
    override fun updateDb(params: UserEntity) {
        AppDataBase.instance.useDao().insert(params)
    }

    override fun deleteDb(params: UserEntity) {
        AppDataBase.instance.useDao().delete()
    }

    override fun insertDb(params: UserEntity) {
        AppDataBase.instance.useDao().insert(params)
    }
}