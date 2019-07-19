package com.xiamuyao.ulanbator.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.adapter.BaseListAdapter

object BindingAdapters {

    @BindingAdapter("nowCurrentTab")
    @JvmStatic
    fun setViewPagerCurrentTab(view: ViewPager, index: Int) {
        view.setCurrentItem(index,false)
    }

    @BindingAdapter("netImage")
    @JvmStatic
    fun setImageViewWithNetWork(view: ImageView, url: String) {
        Glide.with(App.CONTEXT)
            .load(url)
            .into(view)
    }

    @BindingAdapter("netCircleImage")
    @JvmStatic
    fun setImageViewWithNetWorkByCircle(view: ImageView, url: String) {

        Glide.with(App.CONTEXT)
            .load(url)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(view)
    }

    @BindingAdapter("defaultStyle")
    @JvmStatic
    fun setDefaultStyle(view: RecyclerView, mAdapter: BaseListAdapter<*>) {
        view.adapter = mAdapter
        view.layoutManager = LinearLayoutManager(App.CONTEXT)
    }
}