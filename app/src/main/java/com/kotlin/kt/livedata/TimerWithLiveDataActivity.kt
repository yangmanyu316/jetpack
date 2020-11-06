package com.kotlin.kt.livedata

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_live_data.*

/**
 * @ClassName: LiveDataActivity
 * @Description: LiveData
 * @Author: yangmanyu
 * @Date: 2020/11/3 10:50
 */

class TimerWithLiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        iniComponent()
    }

    private fun iniComponent() {
        //通过ViewModelProviders得到ViewModel
        val timerWithLiveDataViewModel = ViewModelProvider(this).get(TimerWithLiveDataViewModel::class.java)

        //得到ViewModel中的LiveData
        val liveData = timerWithLiveDataViewModel.getCurrentSecond() as MutableLiveData<Int>

        //通过LiveData.observe()实现对ViewModel中数据变化的观察
        liveData.observe(this, Observer { second -> //更新UI界面
            tv_live_data.text = "TIME:$second"
        })

        //与liveData.observe相似，没有绑定owner，在页面任何状态都能接收到通知，需手动调用removeObserver()停止，否则Activity回收，造成内存泄露
//        liveData.observeForever(Observer { second->
//            tv_live_data.text = "Time: $second"
//        })
        btn_live_data.setOnClickListener {
            //通过LiveData.setValue()/LiveData.postValue()实现对ViewModel中数据的更新
            //UI线程中使用 setValue
            liveData.setValue(0)
        }
        timerWithLiveDataViewModel.startTiming()
    }
}