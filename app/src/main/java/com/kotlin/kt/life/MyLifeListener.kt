package com.kotlin.kt.life

import android.app.Activity
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @ClassName: MyLifeListener
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/10/15 15:45
 */
class MyLifeListener(context: Activity?, listener: OnChangeListener?) : LifecycleObserver {
    private fun init() {
        Log.e("lifecycle =>", "do Init")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        Log.e("lifecycle=>", "start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        Log.e("lifecycle=>", "destroy")
    }

    interface OnChangeListener {
        fun onChanged(params: String?)
    }

    init {
        init()
    }
}