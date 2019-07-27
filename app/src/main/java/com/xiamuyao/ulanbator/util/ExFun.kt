package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.ViewDataBinding
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.BaseViewModel

@SuppressLint("ResourceAsColor")
fun <V : ViewDataBinding, VM : BaseViewModel> BaseActivity<V, VM>.setTitleBar(
    title: String = "",
    leftCallBack: (() -> Unit)? = null,
    titleBarColor: Int = R.color.immersionBar,
    rightText: String = "",
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


    val leftTextView = findViewById<TextView>(R.id.titleBarRightText)
    rightCallBack?.let {
        leftTextView.visibility = View.VISIBLE
        leftTextView.setOnClickListener { rightCallBack() }
    }
}