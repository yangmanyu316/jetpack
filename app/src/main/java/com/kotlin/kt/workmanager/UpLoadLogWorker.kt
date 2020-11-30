package com.kotlin.kt.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.DataInput

/**
 * @ClassName: UpLoadLogWorker
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/17 10:47
 */

class UpLoadLogWorker(context: Context, params: WorkerParameters) : Worker(context, params) {


    /**
     * doWork() 有3种类型的返回值
     *
     * success()
     * failure() 执行失败
     * retry()   重新执行
     */
    override fun doWork(): Result {
        //接收从外面传递回来的数据
        val data = inputData.getString("input_data")
        //任务执行完返回的数据
        val outputData: Data = Data.Builder().putString("outPutData", "success").build()
        return Result.success(outputData)
    }

}