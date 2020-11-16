package com.kotlin.kt.livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

/**
 * @ClassName: TimeWithLiveDataViewModel
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/4 13:29
 */
class TimerWithLiveDataViewModel : ViewModel() {
    private val TAG = this.javaClass.name
    private var timer: Timer? = null
    private var currentSecond: MutableLiveData<Int>? = null

    fun getCurrentSecond(): LiveData<Int> {
        if (currentSecond == null) {
            currentSecond = MutableLiveData()
        }
        return currentSecond as MutableLiveData<Int>
    }

    /**
     * 开始计时
     */
    fun startTiming() {
        if (timer == null) {
            currentSecond!!.value = 0
            timer = Timer()
            val timerTask: TimerTask = object : TimerTask() {
                override fun run() {
                    //这里要用postValue方法，而不能用setValue方法，否则会报线程异常错误
                    //非UI线程中使用postValue() UI线程中使用setValue()
                    currentSecond!!.postValue(currentSecond!!.value!! + 1)
                }
            }
            timer!!.schedule(timerTask, 1000, 1000)
        }
    }

    /**
     * 由于屏幕旋转导致的Activity重建，该方法不会被调用
     *
     * 只有ViewModel已经没有任何Activity与之有关联，系统则会调用该方法，你可以在此清理资源
     */
    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared()")
        timer!!.cancel()
    }
}
