package com.aurora.common.room


import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.aurora.common.entity.po.UserEntity
import com.aurora.common.room.dao.UserDao

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
