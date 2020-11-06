package com.kotlin.kt.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

/**
 * @ClassName: TimerViewModel
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/2 11:15
 */

class TimerViewModel : ViewModel() {

    private var currentSecond: Int = 0
    private var timer: Timer? = null

    fun startTiming() {
        if (timer == null) {
            currentSecond = 0
            timer = Timer()
            val task: TimerTask = object : TimerTask() {
                override fun run() {
                    currentSecond++
                    onTimeChangeListener?.onTimeChanged(currentSecond)
                }
            }

            timer!!.schedule(task,1000,1000)
        }
    }

    interface OnTimeChangeListener {
        fun onTimeChanged(second: Int)
    }

    private var onTimeChangeListener: OnTimeChangeListener? = null

    fun setOnTimeChangeListener(listener: OnTimeChangeListener) {
        onTimeChangeListener = listener
    }

    override fun onCleared() {
        super.onCleared()
        timer!!.cancel()
    }
}