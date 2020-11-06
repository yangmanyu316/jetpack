package com.kotlin.kt.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

class ForecastListAdapter(private val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(TextView(parent.context))
    }


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textview.text = items[p1]
    }

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview)
}