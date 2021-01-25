package com.kotlin.kt.mvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kotlin.kt.mvvm.model.User

/**
 * @ClassName: UserDao
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 10:49
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?)

    @Delete
    fun deleteUser(user: User?)

    @Query("SELECT * FROM user WHERE name=:name")
    fun getUserByName(name: String?):LiveData<User>?
}