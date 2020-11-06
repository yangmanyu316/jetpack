package com.kotlin.kt.number

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_number_chaper.*

/**
 * @ClassName: NumberChapter
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/7/10 13:52
 */
class NumberChapter : AppCompatActivity(), View.OnClickListener {

    var i = 1
    var d = 1.1
    var f = 1.1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_chaper)
        btn.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }

    private fun printDouble(d: Double) {
        print(d)
        Log.e("printDouble =>", d.toString())
    }

    /**
     *  装箱 原始类型-> 包装类型 调用Integer的valueOf new 一个Integer 并赋值
     *  拆箱 包装类型-> 原始类型 调用Integer 对象的integerValue方法并赋值返回给int
     *  注意数字装箱不⼀定保留同⼀性 int -128 - 127 (100 true 10000 false)
     *  如果在 范围内则从IntegerCache.cache中取值，否则new 一个Integer对象
     *  进行 = 赋值操作（装箱或拆箱）
     *  进行+，-，*，/混合运算 （拆箱）
     *  进行>,<,==比较运算（拆箱）
     *  调用equals进行比较（装箱）
     *  ArrayList,HashMap等集合类 添加基础类型数据时（装箱）
     */
    private fun equality() {
        val a: Int = 100
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        val b: Int = 10000
        val boxedB: Int? = b
        val anotherBoxedB: Int? = b

        //=== 比较地址是否相等 ==比较值是否相等
        Log.e("equality A=>", (boxedA === anotherBoxedA).toString()) //true
        Log.e("equality B=>", (boxedB === anotherBoxedB).toString()) //false
        Log.e("equality B==>", (boxedB == anotherBoxedB).toString()) //true
    }

    /**
     * Kotlin⽀持数字运算的标准集（ + - * / % ），运算被定义为相应的类成员（但编译器会将函数调⽤优化为相应的指
     */
    private fun operation(){
        val x = 5/2
        Log.e("operation / =>",(x==2).toString())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn -> printDouble(d)
            R.id.button2 -> equality()
            R.id.button3 -> operation()
        }
    }
}