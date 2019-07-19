package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.WanAndroidBean
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.GET

interface BusinessService {

    @GET("chapters/json")
    suspend fun getProvinces(): BaseResponse<MutableList<WanAndroidBean.DataBean>>

}