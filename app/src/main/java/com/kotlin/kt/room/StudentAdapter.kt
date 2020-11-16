package com.kotlin.kt.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.adapter_student.view.*

/**
 * @ClassName: StudentAdapter
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/11 11:04
 */

class StudentAdapter(context: Context, list: MutableList<Student>, private val onClick: (Student) -> Unit) : RecyclerView.Adapter<StudentAdapter.Holder>() {

    private var mContext = context
    private var mList = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.Holder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.adapter_student, parent, false)
        return Holder(view, onClick)
    }

    override fun onBindViewHolder(holder: StudentAdapter.Holder, position: Int) {
        val student = mList[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class Holder(view: View, val onClick: (Student) -> Unit) : RecyclerView.ViewHolder(view) {
        private var name = view.tv_name as TextView
        private var age = view.tv_age as TextView
        private var currentStudent: Student? = null

        init {
            view.setOnClickListener {
                currentStudent?.let { onClick(it) }
            }
        }

        fun bind(student: Student) {
            currentStudent = student
            name.text = student.name
            age.text = student.age
        }
    }
}