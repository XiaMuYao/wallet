package com.xiamuyao.ulanbator.view

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.listener.NonDoubleClickListener
import kotlinx.android.synthetic.main.dialog_common_text.*

class CommonDialog private constructor() : BaseDialog() {

    private var title: String? = null
    private var content: String? = null
    private var leftBtnText: String? = null
    private var rightBtnText: String? = null
    private var onLeftCallBack: (() -> Unit)? = null
    private var onRightCallBack: (() -> Unit)? = null
    private var onContentCallBack: (() -> Unit)? = null
    private var rightBtnEnabled = true

    companion object {
        fun create(
            title: String? = null,
            content: String? = null,
            leftBtnText: String? = null,
            onLeftCallBack: (() -> Unit)? = null,
            rightBtnText: String? = null,
            onRightCallBack: (() -> Unit)? = null,
            contentCallBack: (() -> Unit)? = null,
            rightBtnEnabled: Boolean = true
        ): CommonDialog {
            val commonDialog = CommonDialog()
            commonDialog.title = title
            commonDialog.content = content
            commonDialog.leftBtnText = leftBtnText
            commonDialog.onLeftCallBack = onLeftCallBack
            commonDialog.rightBtnText = rightBtnText
            commonDialog.onRightCallBack = onRightCallBack
            commonDialog.onContentCallBack = contentCallBack
            commonDialog.rightBtnEnabled = rightBtnEnabled
            return commonDialog
        }
    }

    override fun initView(view: View) {
        if (title.isNullOrEmpty()) {
            titleTv.visibility = View.GONE
        } else {
            titleTv.text = title
        }
        if (content.isNullOrEmpty()) {
            contentTv.visibility = View.GONE
        } else {
            contentTv.text = content
        }
        if (!leftBtnText.isNullOrEmpty()) {
            leftBtn.visibility = View.VISIBLE
            leftBtn.text = leftBtnText
        } else {
            leftBtn.visibility = View.GONE
        }
        if (!rightBtnText.isNullOrEmpty()) {
            rightBtn.visibility = View.VISIBLE
            rightBtn.text = rightBtnText
        } else {
            rightBtn.visibility = View.GONE
        }
        leftBtn.setOnClickListener {
            dismiss()
            onLeftCallBack?.invoke()
        }
        rightBtn.setOnClickListener {
            dismiss()
            onRightCallBack?.invoke()
        }

        onContentCallBack?.let {
            contentTv.setOnClickListener(NonDoubleClickListener{
                onContentCallBack?.invoke()
            })
        }

        rightBtn.isEnabled = rightBtnEnabled

    }

    override val layoutID: Int
        get() = R.layout.dialog_common_text

    fun setRightBtnEnable(enable: Boolean){
        rightBtn.isEnabled = enable
    }
}