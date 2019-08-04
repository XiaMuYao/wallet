package com.xiamuyao.ulanbator.model.repository

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.model.bean.response.CityListBean
import com.xiamuyao.ulanbator.network.api.UserService
import com.xiamuyao.ulanbator.util.Md5
import com.xiamuyao.ulanbator.util.putSpValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private var userService: UserService) {

    suspend fun getCityList() = withContext(Dispatchers.IO) {
        val tempList = ObservableArrayList<CityListBean.DataBean.ListBean>()
        val cityList = userService.getCityList()
        //todo 这里判断语言 showCityName
        cityList.data.list.forEach {
            it.showCityName = it.titleCN
        }
        tempList.addAll(cityList.data.list)
        return@withContext tempList
    }

    suspend fun register(
        countryCode: String,
        dialingCode: String,
        tel: String,
        password: String,
        passwordConfirm: String,
        verifyCode: String,
        inviteCode: String
    ) = withContext(Dispatchers.IO) {

        val registered = userService.registered(
            countryCode,
            dialingCode,
            tel,
            password,
            passwordConfirm,
            verifyCode,
            inviteCode
        )
        if (registered.result.returnCode == "0") {
            App.CONTEXT.putSpValue("userLoginId", registered.data.userLoginId)
            App.CONTEXT.putSpValue("userLoginToken", registered.data.userLoginToken)
            registered
        } else {
            registered
        }
    }

    suspend fun sendTheVerificationCode(type: String, dialingCode: String, tel: String) = withContext(Dispatchers.IO) {
        val sendTheVerificationCode = userService.sendTheVerificationCode(type, dialingCode, tel)
        if (sendTheVerificationCode.result.returnCode == "0") {
            App.CONTEXT.putSpValue("verifyKey", sendTheVerificationCode.data.verifyKey)
        }

        return@withContext sendTheVerificationCode
    }


    suspend fun logIn(dialingCode: String, tel: String, password: String) = withContext(Dispatchers.IO) {
        val logIn = userService.logIn(dialingCode, tel, Md5.getMD5(password))
        if (logIn.result.returnCode == "0") {
            App.CONTEXT.putSpValue("userLoginId", logIn.data.userLoginId)
            App.CONTEXT.putSpValue("userLoginToken", logIn.data.userLoginToken)
        }
        return@withContext logIn
    }

    suspend fun forgetPassword(
        dialingCode: String,
        tel: String,
        password: String,
        passwordConfirm: String,
        verifyCode: String
    ) = withContext(Dispatchers.IO) {
        val forgetPassword =
            userService.forgetPassword(dialingCode, tel, Md5.getMD5(password), Md5.getMD5(passwordConfirm), verifyCode)

        if (forgetPassword.result.returnCode == "0") {
            App.CONTEXT.putSpValue("userLoginId", forgetPassword.data.userLoginId)
            App.CONTEXT.putSpValue("userLoginToken", forgetPassword.data.userLoginToken)
        }
        return@withContext forgetPassword
    }


    suspend fun setTransactionPassword(password: String, passwordConfirm: String) = withContext(Dispatchers.IO) {
        val transactionPassword = userService.setTransactionPassword(Md5.getMD5(password), Md5.getMD5(passwordConfirm))
        return@withContext transactionPassword
    }


    suspend fun quit() = withContext(Dispatchers.IO) {
        val transactionPassword = userService.quit()
        return@withContext transactionPassword
    }




    companion object {

        private var instance: UserRepository? = null

        fun getInstance(userService: UserService): UserRepository {
            if (instance == null) {
                synchronized(UserRepository::class.java) {
                    if (instance == null) {
                        instance = UserRepository(userService)
                    }
                }
            }
            return instance!!
        }
    }
}
