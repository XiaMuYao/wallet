package com.xiamuyao.ulanbator.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response

import okhttp3.ResponseBody
import java.net.SocketTimeoutException


class CustomNetWorkInterceptor : Interceptor {

    @Throws(SocketTimeoutException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val response = chain.proceed(chain.request())
            return response.newBuilder().body(ResponseBody.create(response.body!!.contentType(), "{\"data\":{},\"errorCode\":0,\"errorMsg\":\"\"}")).build()
        } catch (exception: SocketTimeoutException) {
            exception.printStackTrace()
        }

        return chain.proceed(chain.request())
    }
}

