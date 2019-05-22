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

@Database(
        entities = [UserEntity::class],
        version = 1,
        exportSchema = false
)
abstract class AppDataBase:RoomDatabase() {
    companion object {

        lateinit var instance: AppDataBase

        fun init(context: Context) {
            instance = Room.databaseBuilder(context, AppDataBase::class.java, "room.db").fallbackToDestructiveMigration().build()
        }
    }
    abstract fun useDao(): UserDao
}
