package com.xiamuyao.ulanbator.utlis

import android.content.Context
import android.net.ConnectivityManager

object NetUtils {

    fun isConnectNet(context: Context?): Boolean {
        if (context != null) {
            val conManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = conManager.activeNetworkInfo
            return networkInfo?.isAvailable ?: false
        }
        return true
    }

    fun a(){
        var a = null

    }
}