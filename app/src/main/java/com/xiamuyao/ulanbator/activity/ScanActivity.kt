package com.xiamuyao.ulanbator.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.king.zxing.CaptureActivity
import com.king.zxing.DecodeFormatManager
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.utlis.LL
import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import androidx.core.app.ActivityCompat
import com.xiamuyao.ulanbator.utlis.DataBus


/**
 * 二维码扫描
 */
class ScanActivity : CaptureActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_scan
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)


        captureHelper.playBeep(false)
            .vibrate(true)
            .decodeFormats(DecodeFormatManager.QR_CODE_FORMATS)

        initUI()
    }

    /**
     * 扫码结果回调
     * @param result 扫码结果
     * @return
     */
    override fun onResultCallback(result: String?): Boolean {
        DataBus.postData("CodeResult", result!!)
        return super.onResultCallback(result)
    }


    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, ScanActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}