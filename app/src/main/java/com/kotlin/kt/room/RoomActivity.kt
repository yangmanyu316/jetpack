package com.kotlin.kt.room

import android.content.DialogInterface
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.android.synthetic.main.dialog_student_insert.view.*

/**
 * @ClassName: RoomActivity
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/10 14:19
 */
class RoomActivity : AppCompatActivity() {

    private var myDataBase: MyDataBase? = null
    private var list: MutableList<Student> = ArrayList()
    private var adapter: StudentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        myDataBase = MyDataBase.getInstance(this)
        initView()
        initData()
        initEvent()
    }

    private fun initView() {
        adapter = StudentAdapter(this, list) { student -> adapterOnClick(student) }
        recyclerViewRoom.adapter = adapter
    }

    private fun initData() {
        val studentViewModel : StudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        studentViewModel.getLiveDataStudent().observe(this, Observer { t->
            list.clear()
            list.addAll(t)
            adapter!!.notifyDataSetChanged()
        })
    }

    private fun initEvent() {
        btnInsert.setOnClickListener {
            val view: View = LayoutInflater.from(this).inflate(R.layout.dialog_student_insert, null, false)
            val dialog = AlertDialog.Builder(this).create()
            dialog.setTitle("room insert")
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { _, _ ->
                if (view.edt_user_name.text.toString().isEmpty() || view.edt_user_age.text.toString().isEmpty()) {
                    Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show()

                } else {
                    //insert entity
                    InsertStudentTask(view.edt_user_name.text.toString(), view.edt_user_age.text.toString()).execute()
                }
                dialog.dismiss()
            }

            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "CANCEL") { _, _ ->
                dialog.dismiss()
            }
            dialog.setView(view)
            dialog.show()
        }
    }

    private fun adapterOnClick(student: Student) {
        doUpdate(student)
    }

    private fun doUpdate(student: Student) {
        val view: View = LayoutInflater.from(this).inflate(R.layout.dialog_student_insert, null, false)
        val dialog = AlertDialog.Builder(this).create()
        view.edt_user_name.setText(student.name)
        view.edt_user_age.setText(student.age)
        dialog.setTitle("room update")
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { _, _ ->
            val currentStudent = Student(student.id, view.edt_user_name.text.toString(), view.edt_user_age.text.toString())
            UpdateStudentTask(currentStudent).execute()
            dialog.dismiss()
        }

        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "DELETE") { _, _ ->
            DeleteStudentTask(student).execute()
            dialog.dismiss()
        }
        dialog.setView(view)
        dialog.show()
    }


    inner class InsertStudentTask(val name: String, private val age: String) : AsyncTask<Void?, Void?, Void?>() {

        override fun doInBackground(vararg params: Void?): Void? {
            myDataBase!!.studentDao()!!.insertStudent(Student(name, age))
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            adapter!!.notifyDataSetChanged()
        }
    }

    inner class UpdateStudentTask(private val student: Student) : AsyncTask<Void?, Void?, Void?>() {

        override fun doInBackground(vararg params: Void?): Void? {
            myDataBase!!.studentDao()!!.updateStudent(student)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            adapter!!.notifyDataSetChanged()
        }
    }

    inner class DeleteStudentTask(private val student: Student) : AsyncTask<Void?, Void?, Void?>() {
        override fun doInBackground(vararg params: Void?): Void? {
            myDataBase!!.studentDao()!!.deleteStudent(student)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            adapter!!.notifyDataSetChanged()
        }

    }

}