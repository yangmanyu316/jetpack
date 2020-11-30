package com.kotlin.kt.databinding.eventhandler

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.kotlin.kt.databinding.bindingadapter.BindAdapterActivity
import com.kotlin.kt.databinding.include.DataBindingIncludeActivity

/**
 * @ClassName: EventHandleListener
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/19 15:32
 */
class EventHandleListener(var context: Context) {
    fun onButtonClicked(view: View) {
        Toast.makeText(context, "DataBinding onClick!!!", Toast.LENGTH_SHORT).show()
    }

    fun onNavigation2Include(view: View) {
        val intent = Intent(context, DataBindingIncludeActivity::class.java)
        context.startActivity(intent)
    }

    fun onNavigation2BindingAdapter(view: View) {
        val intent = Intent(context, BindAdapterActivity::class.java)
        context.startActivity(intent)
    }
}