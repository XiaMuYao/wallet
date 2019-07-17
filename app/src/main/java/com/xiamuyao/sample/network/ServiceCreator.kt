package com.xiamuyao.sample.network

import com.xiamuyao.sample.constant.ProjectConstant
import com.xiamuyao.ulanbator.LibApp
import com.xiamuyao.ulanbator.net.CacheInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.Cache
import java.io.File

object ServiceCreator {


    private val httpClient by lazy {

        //添加一个log拦截器,打印所有的log
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        //可以设置请求过滤的水平,body,basic,headers
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .cache(Cache(File(LibApp.getContext().externalCacheDir, "test_cache"), 100 * 1024 * 1024))
            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
            .addInterceptor(CacheInterceptor())

    }


    private val builder = Retrofit.Builder()
        .baseUrl(ProjectConstant.BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())


    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}