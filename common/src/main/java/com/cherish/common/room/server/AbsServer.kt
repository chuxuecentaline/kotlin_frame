package com.cherish.common.room.server

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.cherish.common.room.annotation.DaoType
import com.cherish.common.utils.IntentExtra
import java.io.Serializable

/**
 * @author: cherish
 * @description: 数据库相关的服务
 * @date: 2019/5/20 16:15
 * @version: 2.0
 */
abstract class AbsServer<T>(var name: String) : IntentService(name) {
    open var mHandler = Handler(Looper.getMainLooper())
    override fun onHandleIntent(intent: Intent?) {
        @DaoType val daoType = intent?.getIntExtra(IntentExtra.DAO_TYPE, -1)
        val params = intent!!.getSerializableExtra(IntentExtra.PARAMS) as T
        when (daoType) {
            DaoType.ADD -> insertDb(params)
            DaoType.DELETE -> deleteDb(params)
            DaoType.UPDATE -> updateDb(params)
        }


    }

    /**
     * 更新
     */
    abstract fun updateDb(params: T)

    /**
     * 删除
     */
    abstract fun deleteDb(params: T)

    /**
     * 添加
     */
    abstract fun insertDb(params: T)

    /**
     * 服务
     */
    fun sendService(packageContext: Context, clazz: Class<out IntentService>, @DaoType daoType: Int, params: T): AbsServer<T> {
        val intentService = Intent(packageContext, clazz)
        intentService.putExtra(IntentExtra.DAO_TYPE, daoType)
        intentService.putExtra(IntentExtra.PARAMS, params as Serializable)
        packageContext.startService(intentService)
        return this
    }
}