package com.example.myapplication2.dataModel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.myapplication2.R

class UserData(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String?
) {
    object ImageLoad {
        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            imageUrl?.apply {

            }
            if (imageUrl!=null) {
                Glide.with(view.context)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(view);
            }
        }
    }
}