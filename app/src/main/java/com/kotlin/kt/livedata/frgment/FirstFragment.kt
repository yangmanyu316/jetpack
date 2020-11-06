package com.kotlin.kt.livedata.frgment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.NavAction
import androidx.navigation.findNavController
import com.kotlin.kt.R
import kotlinx.android.synthetic.main.fragment_share_first.*

/**
 * @ClassName: FirstFragment
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/4 16:23
 */

class FirstFragment : Fragment() {

    var liveData: MutableLiveData<String>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shareModel = activity?.let { ViewModelProvider(it).get(ShareDataViewModel::class.java) }

        liveData = shareModel!!.getProgress() as MutableLiveData<String>

        Log.e("first fragment =>", "live data is${liveData}")

        initEvent()
    }

    /**
     * init event
     */
    private fun initEvent() {
        tv_first_fragment.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.e("text changed=>", s.toString())
                liveData!!.postValue(s.toString())
            }
        })


        btn_first_fragment.setOnClickListener { v ->
            v.findNavController().navigate(R.id.action_first_to_second)
        }
    }

}