package com.kotlin.kt.databinding.include

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kotlin.kt.R
import com.kotlin.kt.databinding.ActivityDataBindingBinding
import com.kotlin.kt.databinding.ActivityIncludeBinding
import com.kotlin.kt.databinding.bean.Book

/**
 * @ClassName: DataBindingIncludeActivity
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/19 15:49
 */
class DataBindingIncludeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val includeActivity = DataBindingUtil.setContentView<ActivityIncludeBinding>(this,R.layout.activity_include)
        val book  = Book("include","nana")
        book.rating = 2

        includeActivity.book = book
    }
}