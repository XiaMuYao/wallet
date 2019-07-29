package com.xiamuyao.ulanbator.net.interceptor

import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class CommonParamInterceptor : Interceptor {

    companion object {

        /**
         * 请求方法-GET
         */
        private val REQUEST_METHOD_GET = "GET"

        /**
         * 请求方法POST
         */
        private val REQUEST_METHOD_POST = "POST"

        /**
         * 基础参数-平台号
         */
        private val REQUEST_COMMON_PARAM_PLATFORM = "2"
    }


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        //获取原先的请求对象
        var request = chain.request()
        if (REQUEST_METHOD_GET == request.method) {
            request = addGetBaseParams(request)
        } else if (REQUEST_METHOD_POST == request.method) {
            request = addPostBaseParams(request)
        }
        return chain.proceed(request)
    }


    /**
     * 添加GET方法基础参数
     *
     * @param request
     * @return
     */
    private fun addGetBaseParams(request: Request): Request {
        var request = request
        val httpUrl = request.url
            .newBuilder()
//            .addQueryParameter("platform", REQUEST_COMMON_PARAM_PLATFORM)//平台号
            .build()
        request = request.newBuilder().url(httpUrl).build()
        return request
    }


    /**
     * 添加POST方法基础参数
     *
     * @param request
     * @return
     */
    private fun addPostBaseParams(request: Request): Request {
        var tempRequest: Request = request
        if (request.body is FormBody) {
            val formBody = request.body as FormBody
            val builder = FormBody.Builder()

            for (i in 0 until formBody.size) {
                if (null != formBody.value(i)) {
                    builder.add(formBody.name(i), formBody.value(i))
                }
            }

            builder.addEncoded("appKey", "3b366f4ed1719695a67024a41d39676e")
            builder.addEncoded("devicePlatform", "android")

            tempRequest = request.newBuilder().post(builder.build()).build()
        }
        return tempRequest
    }
}
