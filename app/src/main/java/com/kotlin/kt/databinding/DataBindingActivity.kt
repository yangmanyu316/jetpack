package com.kotlin.kt.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kotlin.kt.R
import com.kotlin.kt.databinding.bean.Book
import com.kotlin.kt.databinding.eventhandler.EventHandleListener

/**
 * @ClassName: DataBindingActivity
 * @Description: DataBinding
 * @Author: yangmanyu
 * @Date: 2020/11/17 16:42
 */

class DataBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataBinding 设置布局
        val activityDataBindingBinding = DataBindingUtil
                .setContentView<ActivityDataBindingBinding>(this, R.layout.activity_data_binding)

        val book = Book("android dataBinding", "Kuroro")
        book.rating = 5
        //将book对象传递到layout中
        activityDataBindingBinding.book = book
        activityDataBindingBinding.eventHandle = EventHandleListener(this)
    }
}