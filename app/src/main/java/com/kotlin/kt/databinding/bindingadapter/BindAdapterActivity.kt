package com.kotlin.kt.databinding.bindingadapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kotlin.kt.R
import com.kotlin.kt.databinding.ActivityBindingAdapterBinding

/**
 * @ClassName: BindAdapterActivity
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/23 10:09
 */
class BindAdapterActivity : AppCompatActivity() {
    var activityBindAdapterActivity: ActivityBindingAdapterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBindAdapterActivity = DataBindingUtil
                .setContentView<ActivityBindingAdapterBinding>(this, R.layout.activity_binding_adapter)
        activityBindAdapterActivity!!.networkImage = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=2&pn=0&spn=0&di=7040&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2583035764%2C1571388243&os=2836418179%2C2424634836&simid=3454139158%2C448793287&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fimg.aiimg.com%2Fuploads%2Fuserup%2F0909%2F2Z64022L38.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bwtt42_z%26e3Bv54AzdH3Frf1AzdH3FdaalalAzdH3F08ma_z%26e3Bip4s&gsm=1&islist=&querylist="
        activityBindAdapterActivity!!.localImage = R.mipmap.ic_launcher_round
        activityBindAdapterActivity!!.imagePadding = 40
        activityBindAdapterActivity!!.clickHandler = ClickHandler()
    }

    inner class ClickHandler {
        fun onClick(view: View) {
            activityBindAdapterActivity!!.imagePadding = 180
        }
    }
}