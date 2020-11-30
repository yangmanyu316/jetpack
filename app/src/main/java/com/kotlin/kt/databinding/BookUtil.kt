package com.kotlin.kt.databinding

/**
 * @ClassName: BookUtil
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/19 14:19
 */

class BookUtil {
    companion object{
        @JvmStatic
        fun getRatingString(rating: Int): String? {
            when (rating) {
                0 -> return "零星"
                1 -> return "一星"
                2 -> return "二星"
                3 -> return "三星"
                4 -> return "四星"
                5 -> return "五星"
            }
            return ""
        }
    }

}