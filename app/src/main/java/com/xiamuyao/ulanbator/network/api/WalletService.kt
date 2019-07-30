package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.response.*
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WalletService {

    /**
     * 获取钱包资产首页
     */
    @FormUrlEncoded
    @POST("wallet/getHome")
    suspend fun getTheWalletAssetHomepage(
        @Field("niu") niu: String = ""
    ): BaseResponse<WalletHomeBean.DataBean>
    /**
     * 获取汇率
     */
    @FormUrlEncoded
    @POST("wallet/getRate")
    suspend fun obtainExchangeRate(
        @Field("niu") niu: String = ""
    ): BaseResponse<RateBean.DataBean>
    /**
     * 获取钱包内页-交易记录
     */
    @FormUrlEncoded
    @POST("wallet/getSymbolDetail")
    suspend fun getWalletInPageTransactionHistory(
        @Field("symbolType") symbolType: String = "",
        @Field("start") start: String = "",
        @Field("index") index: String = ""
    ): BaseResponse<CityListBean.DataBean>
    /**
     * 获取用户钱包地址
     */
    @FormUrlEncoded
    @POST("wallet/getUserWalletAddress")
    suspend fun getUserWalletAddress(
        @Field("symbolType") symbolType: String = ""
    ): BaseResponse<UserWalletAddressBean.DataBean>
    /**
     * 转账
     */
    @FormUrlEncoded
    @POST("/wallet/transfer")
    suspend fun transfer(
        @Field("symbolType") symbolType: String = "",
        @Field("verifyCode") verifyCode: String = "",
        @Field("address") address: String = "",
        @Field("amount") amount: String = "",
        @Field("password") password: String = ""
    ): BaseResponse<TransferBean>
}