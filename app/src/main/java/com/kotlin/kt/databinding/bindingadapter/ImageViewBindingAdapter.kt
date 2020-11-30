package com.kotlin.kt.databinding.bindingadapter

import android.graphics.Color
import android.widget.ImageView
import com.kotlin.kt.R
import com.squareup.picasso.Picasso

/**
 * @ClassName: ImageViewBindingAdapter
 * @Description: java类作用描述
 * @Author: yangmanyu
 * @Date: 2020/11/23 9:36
 */
class ImageViewBindingAdapter {

    companion object {
        fun setImage(imageView: ImageView, imageUrl: String) {
            if (imageUrl.isNotEmpty()) {
                Picasso.get()
                        .load(imageUrl)
                        .placeholder(R.mipmap.ic_launcher_round)
                        .error(R.mipmap.ic_launcher)
                        .into(imageView)
            } else {
                imageView.setBackgroundColor(Color.BLACK)
            }
        }
    }
}