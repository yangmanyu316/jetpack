package com.kotlin.kt.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * @ClassName: SecondFragment
 * @Description: Navigation SecondFragment
 * @Author: yangmanyu
 * @Date: 2020/10/16 11:16
 */

class SecondFragment : Fragment() {

    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //通过bundle 获取参数
//        tv_second_title.text = arguments?.getString("user_name")
        //通过safe args 获取
        tv_second_title.text = "姓名：${args.userName} 年龄：${args.userAge}"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)

    }
}