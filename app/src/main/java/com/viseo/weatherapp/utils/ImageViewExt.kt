package com.viseo.weatherapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageWithUrl(imageUrl: String) {
    Glide.with(this.context)
        .load(imageUrl)
        .into(this)
}