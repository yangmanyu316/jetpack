package com.kotlin.kt.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kotlin.kt.application.MyApplication
import com.kotlin.kt.mvvm.db.UserDao
import com.kotlin.kt.mvvm.db.UserDatabase
import com.kotlin.kt.mvvm.model.User
import com.kotlin.kt.mvvm.repository.UserRepository

/**
 * @ClassName: UserViewModel
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 14:23
 */
class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val user: LiveData<User>?
    private val name = "MichaelYe"
    private val userRepository: UserRepository

    fun getUser(): LiveData<User>? {
        return user
    }

    fun refresh(){
        userRepository.refresh(name)
    }

    init {
        val database: UserDatabase? = MyApplication.getUserDatabase()
        val userDao: UserDao? = database?.userDao()
        userRepository = UserRepository(userDao, MyApplication.getApi())
        user = userRepository.getUser(name)
    }
}
