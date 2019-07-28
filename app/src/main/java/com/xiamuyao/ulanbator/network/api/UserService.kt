package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.dd
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.GET

interface UserService {

    @GET("data/1264816")
    suspend fun getCityList(): BaseResponse<MutableList<dd.DataBean.ListBean>>

}