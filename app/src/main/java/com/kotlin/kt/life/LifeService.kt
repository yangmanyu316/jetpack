package com.kotlin.kt.life

import android.app.Service
import androidx.lifecycle.LifecycleService

/**
 * @ClassName: LifeService
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/10/15 17:21
 */

class LifeService : LifecycleService() {

    init {
        val serviceObserver = MyServiceObserver()
        lifecycle.addObserver(serviceObserver)
    }
}