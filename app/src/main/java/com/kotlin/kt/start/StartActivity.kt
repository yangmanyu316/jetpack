package com.kotlin.kt.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.kt.R
import com.kotlin.kt.adapter.ForecastListAdapter
import com.kotlin.kt.life.MyLifeListener
import kotlinx.android.synthetic.main.activity_start.*

/**
 * @ClassName: StartActivity
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/8/18 13:38
 */
class StartActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        message.text = resources.getString(R.string.start)
        initView()
    }

    private fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ForecastListAdapter(items)
    }

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )



    fun add(x: Int, y: Int): Int = x + y

    override fun onDestroy() {
        super.onDestroy()
    }
}