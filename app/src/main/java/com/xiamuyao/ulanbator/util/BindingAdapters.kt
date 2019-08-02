package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.zhouyou.view.seekbar.SignSeekBar
import com.zhouyou.view.seekbar.SignConfigBuilder
import java.text.NumberFormat


object BindingAdapters {

    @BindingAdapter("nowCurrentTab")
    @JvmStatic
    fun setViewPagerCurrentTab(view: ViewPager, index: Int) {
        view.setCurrentItem(index, false)
    }

//    @SuppressLint("SetTextI18n")
//    @BindingAdapter("roundOffTheZeroAfterTheDecimalPoint")
//    @JvmStatic
//    fun roundOffTheZeroAfterTheDecimalPoint(view: TextView, value: String) {
//        if (value.isEmpty()) return
//        view.text = value.toBigDecimal().stripTrailingZeros().toString()
//    }

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

    /**
     * 3 头像
     */
    @BindingAdapter("netCircleImageLocal")
    @JvmStatic
    fun setImageViewWithLocalByCircle(view: ImageView, type: Int) {
        val tempId: Int = when (type) {
            1 -> R.drawable.logo_01
            2 -> R.drawable.logo_02
            3 -> R.drawable.avatar_01
            else -> R.drawable.logo_01
        }
        Glide.with(App.CONTEXT)
            .load(tempId)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(view)
    }


    @BindingAdapter("setImageWalletShow")
    @JvmStatic
    fun setImageWalletShow(view: ImageView, type: Boolean) {
        view.isSelected = type
    }

    @BindingAdapter("setTextWalletShow")
    @JvmStatic
    fun setTextWalletShow(view: TextView, type: Boolean) {
        if (null == view.tag) return
        if (type) {
            view.text = view.tag.toString()
        } else {
            view.text = "******"
        }
    }

    @BindingAdapter("setViewShowHide")
    @JvmStatic
    fun setViewShowHide(view: View, type: Boolean) {
        if (type) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @BindingAdapter("setpairImage")
    @JvmStatic
    fun setpairImage(view: ImageView, type: String) {
        if (type.isEmpty()) return
        when (type) {
            "BTC" -> {
                view.setImageResource(R.drawable.btc)
            }
            "ETH" -> {
                view.setImageResource(R.drawable.btc)
            }
            "LTC" -> {
                view.setImageResource(R.drawable.btc)
            }
            "EOS" -> {
                view.setImageResource(R.drawable.btc)
            }
            "ETC" -> {
                view.setImageResource(R.drawable.btc)
            }
        }
    }


    @BindingAdapter("contractImageType")
    @JvmStatic
    fun setContractImageType(view: TextView, type: Int) {

        when (type) {
            1 -> {
                view.setBackgroundResource(R.drawable.shape_contract_yirenou)
                view.text = "已认购"
            }
            2 -> {
                view.text = "已满额"
                view.setBackgroundResource(R.drawable.shape_contract_yimane)
            }
            0 -> {
                view.text = "可认购"
                view.setBackgroundResource(R.drawable.shape_contract_kerengou)
            }
        }

    }

    @BindingAdapter("registerSelect")
    @JvmStatic
    fun setRegisterSelect(view: ImageView, type: Boolean) {
        view.isSelected = type
    }

    @BindingAdapter("addPLus")
    @JvmStatic
    fun setRegisterSelect(view: TextView, type: String) {
        view.text = "+$type"
    }

    @BindingAdapter("upOrDown")
    @JvmStatic
    fun setupOrDown(view: TextView, type: String) {
        if (type.isEmpty()) return
        if (type.toDouble() >= 0) {
            view.setBackgroundResource(R.drawable.shape_pair_up)
            view.setText("+${type}%")
        } else {
            view.setBackgroundResource(R.drawable.shape_pair_down)
            view.setText("-${type}%")
        }
    }


    @BindingAdapter("userLever")
    @JvmStatic
    fun setuserLever(view: ImageView, type: Int) {

        var imageId = 0
        when (type) {
            0 -> {
                return
            }
            1 -> {
                imageId = R.drawable.vip1

            }
            2 -> {
                imageId = R.drawable.vip2

            }
            3 -> {
                imageId = R.drawable.vip3

            }
            4 -> {
                imageId = R.drawable.vip4

            }
            5 -> {
                imageId = R.drawable.vip5

            }
        }
        view.setBackgroundResource(imageId)
    }

    @BindingAdapter("phoneFont")
    @JvmStatic
    fun setphoneFont(view: TextView, type: String) {
        if (type.isEmpty()) return
        var first = type.substring(0, 3)

        var after = type.substring(type.length - 4, type.length)
        view.text = "$first****$after"
    }


}