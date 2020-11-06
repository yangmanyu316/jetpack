package com.kotlin.kt.viewmodel

import android.app.AppComponentFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kotlin.kt.R
import com.kotlin.kt.life.MyLifeListener
import kotlinx.android.synthetic.main.activity_view_model.*

/**
 * @ClassName: ViewModelActivity
 * @Description: viewModel
 * @Author: yangmanyu
 * @Date: 2020/11/2 11:01
 */

class ViewModelActivity : AppCompatActivity() {

    init {
        Log.e("view model init=>", "init()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        Log.e("view model on create =>", "on create")
        iniComponent()
    }

    private fun iniComponent() {
        val timerViewModel: TimerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        timerViewModel.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener{
            override fun onTimeChanged(second: Int) {
                runOnUiThread { tv_time.text = second.toString() }
            }
        })

        timerViewModel.startTiming()
    }

}