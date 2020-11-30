package com.kotlin.kt.workmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * @ClassName: CompressLogWorker
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/17 16:24
 */

class CompressLogWorker(context: Context, params: WorkerParameters) : Worker(context, params) {


    override fun doWork(): Result {
        val inputData = inputData.getString("input_data")

        val outData = Data.Builder().putString("out_put", "compress log worker out put data").build()

        return Result.success(outData)
    }

}