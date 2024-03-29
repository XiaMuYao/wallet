package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.CountDownTimer
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R

class CountTime(millisInFuture: Long = 60000, countDownInterval: Long = 1000, var textView: TextView) :
    CountDownTimer(millisInFuture, countDownInterval) {

    var start = false
    @SuppressLint("SetTextI18n")
    override fun onTick(millisUntilFinished: Long) {
        start = true
        textView.setTextColor(Color.WHITE)
        textView.text = "${millisUntilFinished / 1000}s"

    }

    @SuppressLint("ResourceAsColor")
    override fun onFinish() {
        start = false
        textView.setTextColor(ContextCompat.getColor(App.CONTEXT, R.color.phoneCode))
        textView.text = App.CONTEXT.getString(R.string.getphoneCode)
    }
}