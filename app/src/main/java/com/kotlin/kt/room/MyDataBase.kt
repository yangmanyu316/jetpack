package com.kotlin.kt.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @ClassName: MyDataBase
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/10 13:57
 */
@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class MyDataBase : RoomDatabase() {

    companion object {
        private const val dataBaseName = "my_db"
        private var databaseInstance: MyDataBase? = null

        @Synchronized
         fun getInstance(context: Context): MyDataBase? {
            if (databaseInstance == null) {
                databaseInstance = Room
                        .databaseBuilder(context.applicationContext, MyDataBase::class.java, dataBaseName)
                        .build()
            }
            return databaseInstance
        }
    }
    abstract fun studentDao(): StudentDao?
}
