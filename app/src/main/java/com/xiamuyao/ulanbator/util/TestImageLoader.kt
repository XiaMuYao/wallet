package com.xiamuyao.ulanbator.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.previewlibrary.loader.IZoomMediaLoader
import com.previewlibrary.loader.MySimpleTarget

/**
 * Created by yangc on 2017/9/4.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */

class TestImageLoader : IZoomMediaLoader {


    override fun displayImage(@NonNull context: Fragment, @NonNull path: String, imageView: ImageView, @NonNull simpleTarget: MySimpleTarget) {
        Glide.with(context).load(path)
//            .asBitmap()
//            .error(R.drawable.ic_default_image)
            //  .placeholder(android.R.color.darker_gray)
            .fitCenter()
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onLoadFailed(null)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onResourceReady()
                    return false
                }
            })
            .into(imageView)
    }

    override fun displayGifImage(@NonNull context: Fragment, @NonNull path: String, imageView: ImageView, @NonNull simpleTarget: MySimpleTarget) {
        Glide.with(context).load(path)
//            .asGif()
            //可以解决gif比较几种时 ，加载过慢  //DiskCacheStrategy.NONE
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .dontAnimate() //去掉显示动画
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onLoadFailed(null)
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onResourceReady()
                    return false
                }

            })
            .into(imageView)
    }

    override fun onStop(@NonNull context: Fragment) {
        Glide.with(context).onStop()

    }

    override fun clearMemory(@NonNull c: Context) {
        Glide.get(c).clearMemory()
    }
}
