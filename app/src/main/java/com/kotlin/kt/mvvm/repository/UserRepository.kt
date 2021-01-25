package com.kotlin.kt.mvvm.repository

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.kotlin.kt.mvvm.api.Api
import com.kotlin.kt.mvvm.db.UserDao
import com.kotlin.kt.mvvm.model.User
import retrofit2.Call
import retrofit2.Response

/**
 * @ClassName: UserRepository
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 13:41
 */
class UserRepository(private val userDao: UserDao?, private val api: Api?) {

    private val TAG = this.javaClass.name

    fun getUser(name: String?): LiveData<User>? {
        refresh(name)
        return userDao?.getUserByName(name)
    }

    open fun refresh(name: String?) {
        api?.getUser(name)?.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null){
                    Log.d(TAG,"response code = ${response.code()}")
                    insertUser(response.body())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d(TAG,"response error")
            }
        })
    }

    private fun insertUser(user: User?){
        AsyncTask.execute {
            userDao?.insertUser(user)
        }
    }
}