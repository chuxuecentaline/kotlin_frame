package com.cherish.common.room


import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.cherish.common.BuildConfig
import com.cherish.common.entity.po.UserEntity
import com.cherish.common.room.dao.UserDao

/**
 * AppDatabase
 *
 */

@Database(entities = [UserEntity::class],version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun useDao(): UserDao

    companion object {

        /**
         * 获取AppDatabase
         */
        lateinit var instance: AppDataBase
        private set

        fun init(context: Context) {
      //      instance = Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, BuildConfig.DB_NAME).build()
        }
    }
}
