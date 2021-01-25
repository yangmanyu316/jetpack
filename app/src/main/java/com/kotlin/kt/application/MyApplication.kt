package com.kotlin.kt.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.kotlin.kt.mvvm.api.Api
import com.kotlin.kt.mvvm.api.RetrofitClient
import com.kotlin.kt.mvvm.db.UserDatabase

/**
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/10/16 9:36
 */

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        //监视整个app的生命周期，非activity/fragment 生命周期
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
        userDatabase = UserDatabase.getInstance(this)
        api = RetrofitClient.instance?.getApi()
    }

    companion object{
        private var userDatabase:UserDatabase? = null
        private var api: Api? = null

        fun getApi(): Api?{
            return api
        }

        fun getUserDatabase(): UserDatabase? {
            return userDatabase
        }
    }
}

//class MyApplication : Application() {
//    override fun onCreate() {
//        super.onCreate()
//        userDatabase = UserDatabase.getInstance(this)
//        api = RetrofitClient.getInstance().getApi()
//    }
//
//    companion object {
//        private var userDatabase: UserDatabase? = null
//        private var api: Api? = null
//        fun getApi(): Api? {
//            return api
//        }
//
//        fun getUserDatabase(): UserDatabase? {
//            return userDatabase
//        }
//    }
//}
