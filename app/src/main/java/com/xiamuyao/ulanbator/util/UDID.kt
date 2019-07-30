package com.xiamuyao.ulanbator.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.telephony.TelephonyManager
import com.xiamuyao.ulanbator.App

object UDID {

    @SuppressLint("WifiManagerLeak", "MissingPermission")
    fun UDID(): String {


        val deviceId = StringBuilder()
        // 渠道标志
        deviceId.append("a")

        try {
            // wifi mac地址
            val wifi = App.CONTEXT .getSystemService(Context.WIFI_SERVICE) as WifiManager
            val info = wifi.connectionInfo
            val wifiMac = info.macAddress
            if (!wifiMac.isEmpty()) {
                deviceId.append("wifi")
                deviceId.append(wifiMac)
                return deviceId.toString()
            }

            // IMEI（imei）
            val tm = App.CONTEXT .getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val imei = tm.deviceId
            if (imei.isEmpty()) {
                deviceId.append("imei")
                deviceId.append(imei)
                return deviceId.toString()
            }

            // 序列号（sn）
            val sn = tm.simSerialNumber
            if (!sn.isEmpty()) {
                deviceId.append("sn")
                deviceId.append(sn)
                return deviceId.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return deviceId.toString()
    }
}
