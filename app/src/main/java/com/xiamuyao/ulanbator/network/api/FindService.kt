package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.response.FindBean
import com.xiamuyao.ulanbator.model.bean.response.FindInfoBean
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FindService {

    /**
     * 获取发现页信息
     */
    @FormUrlEncoded
    @POST("discovery/getInfo")
    suspend fun getDiscoveryPageInformation(
        @Field("infoType") infoType: String = "",
        @Field("start") start: String = "",
        @Field("index") index: String = ""
    ): BaseResponse<FindBean.DataBean>


    /**
     * 读取信息
     */
    @FormUrlEncoded
    @POST("discovery/readInfoDetail")
    suspend fun readInformation(
        @Field("infoId") infoId: String = ""
    ): BaseResponse<FindInfoBean>
}