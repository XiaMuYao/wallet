package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.ViewDataBinding
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.LoginActivity
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.net.BaseResponse
import com.xiamuyao.ulanbator.net.Status
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.To
import com.xiamuyao.ulanbator.utlis.putSpValue
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ResourceAsColor")
fun <V : ViewDataBinding, VM : BaseViewModel> BaseActivity<V, VM>.setTitleBar(
    title: String = "",
    leftCallBack: (() -> Unit)? = null,
    titleBarColor: Int = R.color.immersionBar,
    rightText: String = "",
    rightImageView: Int? = null,
    rightCallBack: (() -> Unit)? = null

) {
    val titleView = findViewById<TextView>(R.id.titleBarTitle)
    title.takeIf { it.isNotEmpty() }?.let {
        titleView.visibility = View.VISIBLE
        titleView.text = it
    }

    val leftImageVIew = findViewById<ImageView>(R.id.titleBarLeftImage)
    leftCallBack?.let {
        leftImageVIew.visibility = View.VISIBLE
        leftImageVIew.setOnClickListener { leftCallBack() }
    }

    val titleBarLayout = findViewById<ConstraintLayout>(R.id.titleBar)
    titleBarLayout.setBackgroundColor(resources.getColor(titleBarColor))


    val rtghtView = findViewById<TextView>(R.id.titleBarRightText)
    rightText.takeIf { it.isNotEmpty() }?.let {
        rtghtView.visibility = View.VISIBLE
        rtghtView.text = it
    }

    rightCallBack?.let {
        rtghtView.visibility = View.VISIBLE
        rtghtView.setOnClickListener { rightCallBack() }
    }

    val tempRightImageView = findViewById<ImageView>(R.id.titleBarRightImage)
    rightImageView?.let {
        tempRightImageView.visibility = View.VISIBLE
        tempRightImageView.setOnClickListener { rightCallBack!!() }
    }
}

@SuppressLint("SimpleDateFormat")
fun String.toTime(from: String = "yyyy-MM-dd HH:mm:ss"): String? {


    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val sd = sdf.format(Date(this.toLong()))

    return sd
}

fun <T> BaseViewModel.businessHandler(
    data: BaseResponse<T>,
    doingSom: (() -> Unit)? = null
): T {
    when (data.result.returnCode!!.toInt()) {
        Status.SUCCESS -> {
            doingSom?.let {
                it.invoke()
            }
        }
        in 10030..10034 -> {
            App.CONTEXT.putSpValue(ProjectConstant.USER_TOKEN, "")
            startActivity(LoginActivity::class.java)
            ActivityStackManager.getInstance().finishAllActivity()
            To.showToast(data.result.returnUserMessage!!)
        }
        else -> {
            data.result.returnUserMessage?.let {
                To.showToast(it)
            }
        }
    }
    return data.data
}