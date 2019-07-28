package com.xiamuyao.ulanbator.util

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

object BindingAdapters {

    @BindingAdapter("nowCurrentTab")
    @JvmStatic
    fun setViewPagerCurrentTab(view: ViewPager, index: Int) {
        view.setCurrentItem(index, false)
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

    @BindingAdapter("netCircleImageLocal")
    @JvmStatic
    fun setImageViewWithLocalByCircle(view: ImageView, type: Int) {
        val tempId: Int = when (type) {
            1 -> R.drawable.logo_01
            2 -> R.drawable.logo_02
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
            "DTC" -> {
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

                R.drawable.shape_contract_yimane
            }
            3 -> {
                view.text = "可认购"

                R.drawable.shape_contract_kerengou
            }
        }

    }

    @BindingAdapter("registerSelect")
    @JvmStatic
    fun setRegisterSelect(view: ImageView, type: Boolean) {
        view.isSelected = type
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
}