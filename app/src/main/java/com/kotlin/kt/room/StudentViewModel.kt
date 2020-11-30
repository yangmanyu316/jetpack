package com.kotlin.kt.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

/**
 * @ClassName: StudentViewModel
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/12 9:23
 */

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val myDatabase: MyDataBase = MyDataBase.getInstance(application)!!
    private val liveDataStudent: LiveData<MutableList<Student>>
    fun getLiveDataStudent(): LiveData<MutableList<Student>> {
        return liveDataStudent
    }
    init {
        liveDataStudent = myDatabase.studentDao()!!.getStudentList()
    }
}