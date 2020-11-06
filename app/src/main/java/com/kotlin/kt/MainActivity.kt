package com.kotlin.kt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.kotlin.kt.bean.Artist
import com.kotlin.kt.net.Request
import com.kotlin.kt.number.ArrayAndStringChapter
import com.kotlin.kt.number.ControllFlowChapter
import com.kotlin.kt.number.NumberChapter
import com.kotlin.kt.life.LifeActivity
import com.kotlin.kt.livedata.TimerWithLiveDataActivity
import com.kotlin.kt.livedata.frgment.ShareDataWithLiveDataActivity
import com.kotlin.kt.navigation.NavigationActivity
import com.kotlin.kt.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var pro: String? = null
    val pro1: String = "Init value!"


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "message"
        pro = "not null"
        nicToast(pro!!, "myTag")
//        getChar()
        initView()
//        fetch()
//        Log.e("action =",this.intent.action)
//        Log.e("data =",intent.data?.scheme)
    }

    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun addR(x: Int, y: Int): Int = x + y

    fun toast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, length).show()
    }

    private fun nicToast(message: String, tag: String = MainActivity::class.java.simpleName, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$tag] $message", length).show()
    }

    private fun initView() {
        Log.e("appId", application.packageName)
        Log.e("versionName", BuildConfig.VERSION_NAME)
        button.setOnClickListener(this)
        button1.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button9.setOnClickListener(this)
        button10.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }

    private fun getChar() {
        val ex: String = "Example"
        var artist: Artist? = null
        Log.e("Artist", artist?.name ?: "123")
        nicToast(ex[2].toString(), "tag")
    }

    private fun fetch() {
        val url: String = "https://www.easy-mock.com/mock/5ca2fced48c9b95777fd3bab/example/proxy"
        Request(url).run()

    }

    override fun onClick(v: View?) {
        val intent = Intent()
        when (v?.id) {
            R.id.button -> {
                intent.setClass(this, NumberChapter::class.java)
            }
            R.id.button1->{
                intent.setClass(this, ViewModelActivity::class.java)
            }
            R.id.button2->{
                intent.setClass(this, TimerWithLiveDataActivity::class.java)
            }
            R.id.button3->{
                intent.setClass(this, ShareDataWithLiveDataActivity::class.java)
            }
            R.id.button4 -> {
                intent.setClass(this, ArrayAndStringChapter::class.java)
            }
            R.id.button5 -> {
                intent.setClass(this, NavigationActivity::class.java)
            }
            R.id.button9 -> {
                intent.setClass(this, ControllFlowChapter::class.java)
            }
            R.id.button10 -> {
                intent.setClass(this, LifeActivity::class.java)
            }
        }
        startActivity(intent)
    }
}
