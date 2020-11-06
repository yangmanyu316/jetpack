package com.kotlin.kt.application

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @ClassName: ApplicationObserver
 * @Description: Application observer
 * @Author: yangmanyu
 * @Date: 2020/10/16 9:38
 */
open class ApplicationObserver : LifecycleObserver{
    val TAG = this.javaClass.name

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.e(TAG,"application onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.e(TAG,"application onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.e(TAG, "application onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.e(TAG, "application onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        Log.e(TAG, "application onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.e(TAG, "application onDestroy")
    }

}