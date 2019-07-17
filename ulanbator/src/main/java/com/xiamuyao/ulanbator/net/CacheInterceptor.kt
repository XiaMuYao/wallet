package com.xiamuyao.ulanbator.net

import com.xiamuyao.ulanbator.LibApp
import com.xiamuyao.ulanbator.utlis.NetUtils
import okhttp3.CacheControl
import okhttp3.Interceptor

import java.io.IOException

class CacheInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        val netAvailable = NetUtils.isConnectNet(LibApp.getContext())

        request = if (netAvailable) {
            request.newBuilder()
                //网络可用 强制从网络获取数据
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        } else {
            request.newBuilder()
                //网络不可用 从缓存获取
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
        }
        var response = chain.proceed(request)
        response = if (netAvailable) {
            response.newBuilder()
                .removeHeader("Pragma")
                // 有网络时 设置缓存超时时间24个小时
                .header("Cache-Control", "public, max-age=" + 24 * 60 * 60)
                .build()
        } else {
            response.newBuilder()
                .removeHeader("Pragma")
                // 无网络时，设置超时为1周
                .header("Cache-Control", "public, only-if-cached, max-stale=" + 7 * 24 * 60 * 60)
                .build()
        }
        return response
    }
}