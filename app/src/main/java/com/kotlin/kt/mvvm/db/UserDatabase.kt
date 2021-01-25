package com.kotlin.kt.mvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlin.kt.mvvm.model.User

/**
 * @ClassName: UserDatabase
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 10:19
 */
@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?

    companion object {
        private const val DATABASE_NAME = "user_db"
        private var databaseInstance: UserDatabase? = null
        @Synchronized
        fun getInstance(context: Context): UserDatabase? {
            if (databaseInstance == null) {
                databaseInstance = Room
                        .databaseBuilder(context.applicationContext, UserDatabase::class.java, DATABASE_NAME)
                        .build()
            }
            return databaseInstance
        }
    }
}