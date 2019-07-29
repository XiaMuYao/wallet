package com.xiamuyao.ulanbator.network

import com.xiamuyao.ulanbator.LibApp
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.net.interceptor.CacheInterceptor
import com.xiamuyao.ulanbator.net.interceptor.CommonParamInterceptor
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


object ServiceCreator {


    private val httpClient by lazy {

        //可以设置请求过滤的水平,body,basic,headers
        OkHttpClient.Builder()
            .cache(Cache(File(LibApp.getContext().externalCacheDir, "test_cache"), 100 * 1024 * 1024))
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(providerInterceptor()) //公共参数
            .addInterceptor(providerNetworkInterceptor()) //日志拦截器
            .addInterceptor(providerCacheInterceptor()) //缓存拦截器

    }


    /**
     * 基础公共参数拦截器
     * @return Interceptor
     */
    private fun providerInterceptor(): Interceptor {
        return CommonParamInterceptor()
    }

    /**
     * 缓存拦截器
     * @return Interceptor
     */
    private fun providerCacheInterceptor(): Interceptor {
        return CacheInterceptor()
    }

    /**
     * 提供网络请求返回信息打印拦截器
     */
    private fun providerNetworkInterceptor(): Interceptor {
        //添加一个log拦截器,打印所有的log
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }


    private val builder = Retrofit.Builder()
        .baseUrl(ProjectConstant.BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())


    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}