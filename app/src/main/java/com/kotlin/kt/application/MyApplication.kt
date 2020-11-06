package com.kotlin.kt.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

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
    }
}