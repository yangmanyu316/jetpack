package com.kotlin.kt.life

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kt.R
import com.kotlin.kt.life.MyLifeListener.OnChangeListener
import kotlinx.android.synthetic.main.activity_start.*

/**
 * @ClassName: LifeActivity
 * @Description: LifeCycle
 * @Author: yangmanyu
 * @Date: 2020/10/15 16:25
 */
class LifeActivity : AppCompatActivity() {

    /**
     * ComponentActivity implements LifecycleOwner
     * we just need to implement LifecycleObserver
     * and call lifecycle.addObserver(observer)
     */

    private var myLifeListener: MyLifeListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)
        myLifeListener = MyLifeListener(this, object : OnChangeListener {
            override fun onChanged(params: String?) {
            }
        })
        initEvent()
        lifecycle.addObserver(myLifeListener!!)
    }

    private fun initEvent() {
        start_service.setOnClickListener {
            intent = Intent(this, LifeService::class.java)
            startService(intent)
        }

        stop_service.setOnClickListener {
            intent = Intent(this, LifeService::class.java)
            stopService(intent)
        }
    }

}