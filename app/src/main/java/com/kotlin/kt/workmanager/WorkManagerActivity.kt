package com.kotlin.kt.workmanager

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_work_manager.*

/**
 * @ClassName: WorkManagerActivity
 * @Description:1. WorkManager 针对的是不需要即时完成的任务
 *              2.保证任务一定会执行，(包括退出或者重启app)workManager有自己的内置数据库
 *              3.最低兼容到api 14
 *              4.根据设备的情况选择不同的执行方案，在API大于23设备通过jobScheduler完成任务
 *                在api小于23通过AlarmManager 和Broadcast Receivers组合完成任务
 *              5.workManager 不是一种新的工作线程，它的出现不是为了替代其他类型的工作线程
 *                  工作线程通常是立即执行，并在任务执行完成后给用户反馈，workManager不是即时的
 *                  ，不能保证任务立即得到执行。
 * @Author: yangmanyu
 * @Date: 2020/11/17 10:41
 */

class WorkManagerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)
        startOneTimeTask()
        initEvent()
//        startPeriodicTask()
    }

    /**
     * 开启一次性任务
     */
    private fun startOneTimeTask() {
        //1.初始化任务触发条件
        val constraints = Constraints.Builder()
                //充电状态
                .setRequiresCharging(true)
                //网络状态
                .setRequiredNetworkType(NetworkType.CONNECTED)
                //电池电量
                .setRequiresBatteryNotLow(true)
                .build()
        //2.将任务触发条件设置到workRequest.
        //  workRequest是一个抽象类，有2种实现方式-OneTimeWorkRequest 和 PeriodicWorkRequest
        //  分别对应一次性任务与周期性任务

        //参数传递
        val inputData = Data.Builder().putString("input_data", "this is work manager input data test!").build()

        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(UpLoadLogWorker::class.java)
                //设置触发条件
                .setInitialDelay(10000, TimeUnit.MILLISECONDS)
                .setInputData(inputData)
                .setBackoffCriteria(BackoffPolicy.LINEAR,
                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                        TimeUnit.MILLISECONDS)
                .addTag("upLoadTag")
                .build()
        //3.设置执行延时执行任务
        //如果假设没有设置触发条件，或者设置的条件此刻符合系统的执行要求，此时系统可能会立即执行该任务。
        //但是如果你希望延时执行可以通过setInitialDelay()

//        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(UpLoadLogWorker::class.java)
//                .setInitialDelay(1000,TimeUnit.MILLISECONDS)
//                .build()

        //4.设置指数退避策略
        //假设worker线程执行出现了异常，如果服务器宕机，可以过一段时间进行重试任务，那么可以在worker的doWork()
        //方法找那个返回Result.retry(),系统会有默认的指数退避策略帮助重试任务，也可通过setBackoffCriteria()
        //方法自定义指数退避策略

//        val uploadWorkerRequest = OneTimeWorkRequest.Builder(UpLoadLogWorker::class.java)
//                .setBackoffCriteria(BackoffPolicy.LINEAR,
//                        OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
//                        TimeUnit.MILLISECONDS)
//                .build()
        //5.为任务设置tag 标签
        //设置标签后你就可以通过该标签跟踪任务的状态，WorkManager.getWorkInfosByTagLiveData(tag:String)
        //也可以取消任务 WorkManager.cancelAllWorkByTag(tag:String)

//        val tagWorkRequest = OneTimeWorkRequest.Builder(UpLoadLogWorker::class.java)
//                .addTag("uploadTag")
//                .build()
        //6.将任务配置好后 需要将其提交给系统。
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)

        //观察任务状态
        //可以通过WorkInfo 获取任务的状态，WorkInfo包含任务的id,tag,worker对象传递过来的outPutData,已经当前任务的状态
        //有3种方法获取 WorkManager.getWorkInfosByTag()|| getWorkInfoById()|| getWorkInfoForUniqueWork()
        //如果希望实时获取任务状态，这3个方法还有对应的LiveData方法
        //getWorkInfosByTagLiveData() .....

        WorkManager.getInstance(this)
                .getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
                .observe(this, Observer {
                    Log.d("onChanged()->", it.toString())
                    if (it != null && it.state == WorkInfo.State.SUCCEEDED) {
                        val outputData = it.outputData.getString("outPutData")
                        Toast.makeText(this@WorkManagerActivity, outputData, Toast.LENGTH_SHORT).show()
                    }
                })
    }

    private fun initEvent() {
        btn_work_cancel.setOnClickListener {
            cancelAllTask()
        }
    }


    /**
     * 周期任务队列
     */
    private fun startPeriodicTask() {
        //设置触发条件
        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .setRequiresStorageNotLow(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true)
                .build()

        val inputData = Data.Builder().putString("input_data", "this is periodic task data").build()

        val request = PeriodicWorkRequest.Builder(UpLoadLogWorker::class.java, 5, TimeUnit.SECONDS)
                .setInputData(inputData)
                .setConstraints(constraints).build()
        WorkManager.getInstance(this).enqueue(request)

        WorkManager.getInstance(this).getWorkInfosByTagLiveData("upLoadTag")
                .observe(this, Observer { it ->
                    Log.e("PeriodicTask ->", it.toString())
                    it.map { item ->
                        if (item != null && item.state == WorkInfo.State.SUCCEEDED) {
                            Toast.makeText(this, item.outputData.getString("outPutData"), Toast.LENGTH_SHORT).show()
                        }
                    }
                })
    }

    /**
     * 并发队列
     */
    private fun startChainTask() {
        //init first
        val constraints = Constraints.Builder().setRequiresCharging(true).build()

        val firstRequest = OneTimeWorkRequest.Builder(CompressLogWorker::class.java)
                .setConstraints(constraints)
                .build()

        val secondRequest = OneTimeWorkRequest.Builder(UpLoadLogWorker::class.java)
                .setConstraints(constraints)
                .build()

        WorkManager.getInstance(this).beginWith(firstRequest)
                .then(secondRequest)
                .enqueue()

    }


    /**
     * 取消任务
     */
    private fun cancelAllTask() {
        //全部取消
        WorkManager.getInstance(this).cancelAllWork()
        //通过tag取消
//        WorkManager.getInstance(this).cancelAllWorkByTag("upLoadTag")
    }
}