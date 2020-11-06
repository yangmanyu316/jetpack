package com.kotlin.kt.livedata.frgment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.activity_array_chapter.*
import kotlinx.android.synthetic.main.fragment_share_second.*

/**
 * @ClassName: SecondFragment
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/4 16:25
 */

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = activity?.let { ViewModelProvider(it).get(ShareDataViewModel::class.java) }
        val data = model!!.getProgress()

        activity?.let {
            data.observe(it, Observer { data ->
            tv_second_fragment.text = data
        })
        }

    }
}