package com.kotlin.kt.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @ClassName: StudentDao
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/10 13:47
 */
@Dao
interface StudentDao {
    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getStudentList(): LiveData<MutableList<Student>>

    @Query("SELECT * FROM student where id= :id")
    fun getStudentById(id: Int): Student
}