package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.media.Image
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
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency
import com.zhouyou.view.seekbar.SignSeekBar
import com.zhouyou.view.seekbar.SignConfigBuilder
import java.text.NumberFormat


object BindingAdapters {

    @BindingAdapter("nowCurrentTab")
    @JvmStatic
    fun setViewPagerCurrentTab(view: ViewPager, index: Int) {
        view.setCurrentItem(index, false)
    }

    @BindingAdapter("selectType")
    @JvmStatic
    fun setselectType(view: ImageView, index: Int) {
        if (view.tag == index.toString()) {
            view.setImageResource(R.drawable.check)
        } else {
            view.setImageResource(0)
        }
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
            4 -> R.drawable.nopen
            5 -> R.drawable.nopen2
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

    @BindingAdapter(value = ["setTextWalletShow", "valueis"], requireAll = false)
    @JvmStatic
    fun setTextWalletShow(view: TextView, setTextWalletShow: Boolean, valueis: String) {
        if (setTextWalletShow) {

            val tempPrirName = getSelectCurrency()
            when {
                tempPrirName.contains("CNY") -> {
                    view.text = "¥$valueis"
                }
                tempPrirName.contains("USD") -> {
                    view.text = "$$valueis"

                }
                tempPrirName.contains("JPY") -> {
                    view.text = "￥$valueis"

                }
                tempPrirName.contains("KRW") -> {
                    view.text = "₩$valueis"

                }
            }


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
                view.setImageResource(R.drawable.eth)
            }
            "LTC" -> {
                view.setImageResource(R.drawable.ltc)
            }
            "EOS" -> {
                view.setImageResource(R.drawable.eos)
            }
            "ETC" -> {
                view.setImageResource(R.drawable.etc)
            }
            "BCH" -> {
                view.setImageResource(R.drawable.bch)
            }
            "DASH" -> {
                view.setImageResource(R.drawable.dash)
            }
            "DOGE" -> {
                view.setImageResource(R.drawable.doge)
            }
            "TRX" -> {
                view.setImageResource(R.drawable.trx)
            }
            "XRP" -> {
                view.setImageResource(R.drawable.xrp)
            }
            "MFT" -> {
                view.setImageResource(R.drawable.mft3)
            }
        }
    }


    @BindingAdapter("contractImageType")
    @JvmStatic
    fun setContractImageType(view: TextView, type: Int) {

        when (type) {
            1 -> {
                view.setBackgroundResource(R.drawable.shape_contract_yirenou)
                view.text = App.CONTEXT.getString(R.string.yirengou)
            }
            2 -> {
                view.text = App.CONTEXT.getString(R.string.yimane)
                view.setBackgroundResource(R.drawable.shape_contract_yimane)
            }
            0 -> {
                view.text = App.CONTEXT.getString(R.string.yirengoul)
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
            view.setText("${type}%")
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


    @SuppressLint("SetTextI18n")
    @BindingAdapter("currencyFormatting")
    @JvmStatic
    fun currencyFormatting(view: TextView, type: String) {
//        人民币￥，美金$，韩币₩，日元¥
        val tempPrirName = getSelectCurrency()
        when {
            tempPrirName.contains("CNY") -> {
                view.text = "¥$type"
            }
            tempPrirName.contains("USD") -> {
                view.text = "$$type"

            }
            tempPrirName.contains("JPY") -> {
                view.text = "￥$type"

            }
            tempPrirName.contains("KRW") -> {
                view.text = "₩$type"

            }
        }

    }

    @SuppressLint("SetTextI18n")
    @BindingAdapter("currencyFormattingAndPair")
    @JvmStatic
    fun currencyFormattingAndPair(view: TextView, type: String) {

        var tempPair = ArithUtil.convertNumber3(type,4)
//        人民币￥，美金$，韩币₩，日元¥
        val tempPrirName = getSelectCurrency()
        when {
            tempPrirName.contains("CNY") -> {
                view.text = "¥$tempPair CNY"
            }
            tempPrirName.contains("USD") -> {
                view.text = "$$tempPair USD"

            }
            tempPrirName.contains("JPY") -> {
                view.text = "￥$tempPair JPY"

            }
            tempPrirName.contains("KRW") -> {
                view.text = "₩$tempPair KRW "

            }
        }

    }

    @BindingAdapter("circleLocalImage")
    @JvmStatic
    fun setcircleLocalImage(view: ImageView, url: Int) {

        Glide.with(App.CONTEXT)
            .load(url)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(view)
    }


}