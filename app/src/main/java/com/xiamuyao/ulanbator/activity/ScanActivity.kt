package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.king.zxing.CaptureActivity
import com.xiamuyao.ulanbator.R

/**
 * 二维码扫描
 */
class ScanActivity : CaptureActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, ScanActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}