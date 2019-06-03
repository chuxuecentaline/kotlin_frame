package com.aurora.common.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aurora.common.entity.po.UserEntity
import io.reactivex.Flowable

/**
 * @author: aurora
 * @description: 用户
 * @date: 2019/5/20 15:57
 * @version: 2.0
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: UserEntity)

    @Query("DELETE FROM user ")
    fun delete(): Int

    @Query("SELECT COUNT(*) FROM user")
    fun count(): Flowable<Int>

    @Query("select * from user LIMIT 1")
    fun query(): Flowable<UserEntity>

}