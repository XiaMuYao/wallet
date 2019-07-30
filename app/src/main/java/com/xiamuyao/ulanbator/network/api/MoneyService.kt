package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.response.*
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MoneyService {

    /**
     * 理财首页信息
     */
    @FormUrlEncoded
    @POST("product/getHome")
    suspend fun financialHomeInformation(
        @Field("niu") niu: String = ""
    ): BaseResponse<GetMoenyInfoBean.DataBean>

    /**
     * 获取理财账户详情
     */
    @FormUrlEncoded
    @POST("product/getProductAccount")
    suspend fun getFinancialAccountDetails(
        @Field("niu") niu: String = ""
    ): BaseResponse<MoneyAccountInfoBean.DataBean>
    /**
     * 获取理财产品
     */
    @FormUrlEncoded
    @POST("product/getProduct")
    suspend fun accessToWealthManagementProducts(
        @Field("productType") productType: String = "",
        @Field("start") start: String = "",
        @Field("index") index: String = ""
    ): BaseResponse<GetMoneyShopBean.DataBean>
    /**
     * 购买理财产品
     */
    @FormUrlEncoded
    @POST("product/buyProduct")
    suspend fun buyingWealthManagementProducts(
        @Field("productId") productId: String = "",
        @Field("amount") amount: String = "",
        @Field("symbolType") symbolType: String = ""
    ): BaseResponse<ByMoneyShopBean.DataBean>
    /**
     * 解除合约
     */
    @FormUrlEncoded
    @POST("product/cancelProduct")
    suspend fun transfer(
        @Field("productId") productId: String = ""
    ): BaseResponse<CancelBean>
}