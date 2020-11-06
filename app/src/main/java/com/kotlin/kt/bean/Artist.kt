package com.kotlin.kt.bean

/**
 * @ClassName: Artist
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/8/17 17:24
 */
data class Artist(
        var id: Long,
        var name: String,
        var url: String,
        var mbid: String
)