package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.WanAndroidBean
import com.xiamuyao.ulanbator.model.bean.response.GetVerSion
import com.xiamuyao.ulanbator.model.bean.response.MyUserBean
import com.xiamuyao.ulanbator.model.bean.response.SetUserBean
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

}