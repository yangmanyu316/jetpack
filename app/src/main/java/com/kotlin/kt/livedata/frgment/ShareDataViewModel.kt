package com.kotlin.kt.livedata.frgment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @ClassName: ShareDataViewModel
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/4 16:12
 */

class ShareDataViewModel : ViewModel() {

    private var params: MutableLiveData<String>? = null
    private val Tag: String = javaClass.name

    fun getProgress(): MutableLiveData<String> {
        if (null == params) {
            params = MutableLiveData()
        }
        return params as MutableLiveData<String>
    }

    fun setParams(){
        
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(Tag, "share data view model is cleared!!!")
        params = null
    }

}