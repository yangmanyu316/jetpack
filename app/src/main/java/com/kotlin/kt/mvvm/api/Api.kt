package com.kotlin.kt.mvvm.api

import com.kotlin.kt.mvvm.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @ClassName: Api
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 10:57
 */
interface Api {
    @GET("/users/{userId}")
    fun getUser(@Path("userId") userId: String?): Call<User>

}