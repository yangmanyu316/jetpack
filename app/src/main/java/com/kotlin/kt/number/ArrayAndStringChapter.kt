package com.kotlin.kt.number

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_array_chapter.*

/**
 * @ClassName: ArrayChapter
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/7/13 9:19
 */

class ArrayAndStringChapter : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_chapter)
        arrayTest1()
        stringTest()
    }


    private fun arrayTest1() {

        val asc = Array(5) { i -> (i * i).toString() }

        asc.forEach {
            Log.e("asc item =>", it)
        }

        val x: IntArray = intArrayOf(1, 2, 3)

        x[0] = x[1] + x[2]

        Log.e("array summing =>", x[0].toString())

        val arr = IntArray(5)

        arr.forEach {
            Log.e("arr item =>", it.toString())
        }

        val arr1 = IntArray(5) { 42 }
        arr1.forEach {
            Log.e("aar1 item =>", it.toString())
        }

        //使⽤ lambda 表达式初始化数组中的值
        // ⼤⼩为 5、值为 [0, 1, 2, 3, 4] 的整型数组（值初始化为其索引值）
        val arr2 = IntArray(5) { it * 1 }

        arr2.forEach {
            Log.e("aar2 item =>", it.toString())
        }
    }

    private fun stringTest() {
        val s = "Hello, world!"
        textView.text = s
        val asc = IntArray(5) { it * 1 }
        val text = """ |Tell me and I forget. |Teach me and I remember. |Involve me and I learn. |(Benjamin Franklin) """.trimMargin()
        textView.text = text
        //字符串模板

        asc.forEach {
           println("$s length =${s.length}")
        }
    }

}