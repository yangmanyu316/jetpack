package com.kotlin.kt.livedata.frgment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kt.R

/**
 * @ClassName: ShareDataWithLiveDataActivity
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/4 16:20
 */

class ShareDataWithLiveDataActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_data_with_live_data)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}