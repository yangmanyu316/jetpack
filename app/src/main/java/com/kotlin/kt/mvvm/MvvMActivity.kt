package com.kotlin.kt.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kotlin.kt.R
import com.kotlin.kt.databinding.ActivityMvvmBinding
import com.kotlin.kt.mvvm.model.User
import com.kotlin.kt.mvvm.viewmodel.UserViewModel

/**
 * @ClassName: MvvMActivity
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2021/1/20 15:14
 */
class MvvMActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        val activityMainBinding: ActivityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)
        val userViewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getUser()?.observe(this, Observer<User> {
            if (it != null){
                activityMainBinding.user = it
            }
        })

        val swipeRefresh: SwipeRefreshLayout = activityMainBinding.swipe

        swipeRefresh.setOnRefreshListener {
            userViewModel.refresh()
            swipeRefresh.isRefreshing = false
        }
    }

}