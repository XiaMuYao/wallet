package com.xiamuyao.ulanbator.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object LibBindingAdapters {

    @BindingAdapter("app:imageId")
    @JvmStatic
    fun setImageId(view: ImageView, resId: Int) {
        view.setImageResource(resId)
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun setImageUrl(view: ImageView, url: String?) {
        Glide.with(view.context).load(url).into(view)
    }

}