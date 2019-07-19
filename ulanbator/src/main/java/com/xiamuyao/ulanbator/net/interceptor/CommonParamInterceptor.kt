package com.xiamuyao.ulanbator.net.interceptor

import okhttp3.*

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
        }
        //        else if (REQUEST_METHOD_POST.equals(request.method())) {
        //            request = addPostBaseParams(request);
        //        }
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


    //    /**
    //     * 添加POST方法基础参数
    //     *
    //     * @param request
    //     * @return
    //     */
    //    private Request addPostBaseParams(Request request) {
    //
    //        /**
    //         * request.body() instanceof FormBody 为true的条件为：
    //         * 在ApiService 中将POST请求中设置
    //         * 1，请求参数注解为@FieldMap
    //         * 2，方法注解为@FormUrlEncoded
    //         */
    //        if (request.body() instanceof FormBody) {
    //            FormBody formBody = (FormBody) request.body();
    //            FormBody.Builder builder = new FormBody.Builder();
    //
    //            for (int i = 0; i < formBody.size(); i++) {
    //                //@FieldMap 注解 Map元素中 key 与 value 皆不能为null,否则会出现NullPointerException
    //                if (formBody.value(i) != null)
    //                    builder.add(formBody.name(i), formBody.value(i));
    //            }
    //
    //            builder.add("platform", REQUEST_COMMON_PARAM_PLATFORM)//平台
    //
    //            request = request.newBuilder().post(formBody).build();
    //        }
    //        return request;
    //    }

}
