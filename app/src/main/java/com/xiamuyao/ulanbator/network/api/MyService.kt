package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.WanAndroidBean
import com.xiamuyao.ulanbator.model.bean.response.*
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyService {

    /**
     * 获取用户信息
     */
    @FormUrlEncoded
    @POST("me/getUserInfo")
    suspend fun getUserInformation(@Field("null") niu: String = ""): BaseResponse<MyUserBean.DataBean>

    /**
     * 修改用户信息
     */
    @FormUrlEncoded
    @POST("me/setUserInfo")
    suspend fun modifyUserInformation(@Field("nickname") niu: String): BaseResponse<SetUserBean>

    /**
     * 修改资金密码
     */
    @FormUrlEncoded
    @POST("me/setUserTranPassword")
    suspend fun modifyTheFundPassword(
        @Field("password") password: String,
        @Field("passwordConfirm") passwordConfirm: String,
        @Field("verifyCode") verifyCode: String

    ): BaseResponse<SetUserBean>

    /**
     * 修改登录密码
     */
    @FormUrlEncoded
    @POST("me/setUserLoginPassword")
    suspend fun modifyTheLoginPassword(
        @Field("loginPassword") loginPassword: String,
        @Field("password") password: String,
        @Field("passwordConfirm") passwordConfirm: String,
        @Field("verifyCode") verifyCode: String
    ): BaseResponse<SetUserBean>


    /**
     * 获取邀请返佣统计
     */
    @FormUrlEncoded
    @POST("me/getInviteStatistics")
    suspend fun getInvitationRebateStatistics(@Field("null") niu: String = ""): BaseResponse<GetInviteStatisticsBean.DataBean>

    /**
     * 获取邀请记录
     */
    @FormUrlEncoded
    @POST("me/getInvite")
    suspend fun getTheInvitationRecord(
        @Field("start") start: String,
        @Field("index") index: String

    ): BaseResponse<GetInviteListBean.DataBean>

    /**
     * 获取返佣记录
     */
    @FormUrlEncoded
    @POST("me/getInviteCommission")
    suspend fun getARebateRecord(
        @Field("start") start: String,
        @Field("index") index: String
    ): BaseResponse<GetInviteCommissionBean.DataBean>

    /**
     * 获取返佣详情
     */
    @FormUrlEncoded
    @POST("me/getInviteCommissionDetail")
    suspend fun getRebateDetails(
        @Field("inviteCode") inviteCode: String,
        @Field("start") start: String,
        @Field("index") index: String
    ): BaseResponse<GetInviteCommissionDetailBean.DataBean>

}