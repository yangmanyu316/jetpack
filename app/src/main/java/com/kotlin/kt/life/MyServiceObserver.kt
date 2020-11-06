package com.kotlin.kt.life

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @ClassName: MyServiceListener
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/10/15 17:24
 */

open class MyServiceObserver : LifecycleObserver {

    val TAG = this.javaClass.name

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onServiceStart() {
        Log.e(TAG, "service is onCreate!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onServiceClose() {
        Log.e(TAG, "service is onDestroy!")
    }
}