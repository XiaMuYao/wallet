package com.xiamuyao.ulanbator.network.api

import com.xiamuyao.ulanbator.model.bean.response.*
import com.xiamuyao.ulanbator.net.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    /**
     * 获取城市列表
     */
    @FormUrlEncoded
    @POST("common/getCountry")
    suspend fun getCityList(@Field("key") niu: String = "",
                            @Field("start") start: String = "",
                            @Field("index") index: String = ""): BaseResponse<CityListBean.DataBean>

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("common/login")
    suspend fun logIn(
        @Field("dialingCode") dialingCode: String,
        @Field("tel") tel: String,
        @Field("password") password: String
    ): BaseResponse<LoginBean.DataBean>

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("common/register")
    suspend fun registered(
        @Field("countryCode") countryCode: String,
        @Field("dialingCode") dialingCode: String,
        @Field("tel") tel: String,
        @Field("password") password: String,
        @Field("passwordConfirm") passwordConfirm: String,
        @Field("verifyCode") verifyCode: String,
        @Field("inviteCode") inviteCode: String

    ): BaseResponse<RegisterBean.DataBean>

    /**
     * 发送验证码
     */
    @FormUrlEncoded
    @POST("common/sendCode")
    suspend fun sendTheVerificationCode(
        @Field("type") type: String,
        @Field("dialingCode") dialingCode: String,
        @Field("tel") tel: String

    ): BaseResponse<SendCode.DataBean>

    /**
     * 忘记密码
     */
    @FormUrlEncoded
    @POST("common/forget")
    suspend fun forgetPassword(
        @Field("dialingCode") dialingCode: String,
        @Field("tel") tel: String,
        @Field("password") password: String,
        @Field("passwordConfirm") passwordConfirm: String,
        @Field("verifyCode") verifyCode: String
    ): BaseResponse<ForgetPsdBean.DataBean>

    /**
     * 退出
     */
    @FormUrlEncoded
    @POST("common/logout")
    suspend fun quit(@Field("null") niu: String = ""): BaseResponse<nullBean>

    /**
     * 设置交易密码
     */
    @FormUrlEncoded
    @POST("common/setUserTranPassword")
    suspend fun setTransactionPassword(
        @Field("password") password: String,
        @Field("passwordConfirm") passwordConfirm: String

    ): BaseResponse<nullBean>

    /**
     * 绑定推送
     */
    @FormUrlEncoded
    @POST("common/bind")
    suspend fun bindingPush(@Field("miRegId") miRegId: String,
                            @Field("deviceNo") deviceNo: String): BaseResponse<BindPushBean.DataBean>

    /**
     * 获取最新版本号
     */
    @FormUrlEncoded
    @POST("common/getVersion")
    suspend fun getTheLatestVersionNumber(@Field("null") niu: String = ""): BaseResponse<GetVerSion.DataBean>
}