package com.kotlin.kt.number

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_control_flow.*

/**
 * @ClassName: ControllFlowChapter
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/7/13 13:48
 */

class ControllFlowChapter : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_flow)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
    }

    private fun funIf() {
        val a: Int = 5
        var max: Int? = null
        val b: Int = 6

        max = if (a > b) a else b
        Log.e("max =", "$max")
    }

    private fun funWhen(x: Int) {

        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> {
                // 注意这个块 print("x is neither 1 nor 2")
            }
        }
        //如果很多分⽀需要⽤相同的⽅式处理，则可以把多个分⽀条件放在⼀起，⽤逗号分隔：
        when (x) {
            0, 1 -> print("x == 0 or x == 1")
            else -> print("otherwise")
        }

        //我们也可以检测⼀个值在（in）或者不在（!in）⼀个区间或者集合中
        when (x) {
            in 1..10 -> Log.e("x is in the range", "---")
//            in validNumbers -> print("x is valid")
            !in 10..20 -> Log.e("x is outside the range", "---")
            else -> Log.e("none of the above", "---")
        }

        Log.e("hasPrefix result =", hasPrefix("prefixTest").toString())

        when {
            x == 2 -> Log.e("11111", "22222222")
            else -> {
            }
        }

    }

    /**
     * 是检测⼀个值是（is）或者不是（!is）⼀个特定类型的值。注意：由于智能转换，你可以访问该类型的⽅ 法与属性⽽⽆需任何额外的检测
     */
    private fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    //⾃ Kotlin 1.3 起，可以使⽤以下语法将 when 的主语（subject，译注：指 when 所判断的表达式）捕获到变量中：
//    fun Request.getBody() = when (val response = executeRequest()) {
//        is Success -> response.body
//        is HttpError -> throw HttpException(response.status)
//    }

    private fun funFor(){
        //1 2 3
        for (i in 1..3){
            Log.e("fun for=>", "$i")
        }

        //6 4 2 0
        for (i in 6 downTo 0 step 2){
            Log.e("fun for downTo=>","$i")
        }

        // 0 2 4
        for (i in 0 until 6 step 2){
            Log.e("fun for until=>","$i")
        }

        //10 9 8....1
        for (i in 10 downTo 1){
            println("$i")
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button5 -> funIf()
            R.id.button6 -> funWhen(2)
            R.id.button7 -> funFor()
            else -> {
                Log.e("when else->", "-----------")
            }
        }
    }
}