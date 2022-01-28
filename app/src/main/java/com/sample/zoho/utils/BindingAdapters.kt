package com.sample.zoho.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("android:loadImage")
fun loadImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView)
        .load(imageUrl)
        .centerCrop()
        .circleCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imageView)
}