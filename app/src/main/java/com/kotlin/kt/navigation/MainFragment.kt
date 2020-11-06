package com.kotlin.kt.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @ClassName: MainFragment
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/10/16 10:57
 */

class MainFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // todo init view and event
//        navigation2Fragment()
//        navigation2FragmentWithBundle()
        navigation2FragmentWithSafeArgs()
    }

    /**
     * 跳转
     */
    private fun navigation2Fragment() {
        btn_2fragment.setOnClickListener { v ->
            //navigation to second fragment mode 1
//            Navigation.findNavController(v).navigate(R.id.secondFragment)
            //mode 2
//            v.findNavController().navigate(R.id.secondFragment)
        }
    }

    /**
     * 通过bundle 传参
     */
    private fun navigation2FragmentWithBundle() {
        btn_2fragment.setOnClickListener { v ->
            //通过bundle 传递参数
            val bundle = Bundle()
            bundle.putString("name", "Michel")
            bundle.putInt("age", 22)
            v.findNavController().navigate(R.id.secondFragment, bundle)
        }
    }

    /**
     * 通过safe args 传参
     */
    private fun navigation2FragmentWithSafeArgs() {
        btn_2fragment.setOnClickListener { v ->
            //MainFragmentDirections safe编译生成的文件
            // actionMainFragmentToSecondFragment nag_graph 中action的id生成的方法
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment("Jack", 12)
            v.findNavController().navigate(action)
        }
    }
}