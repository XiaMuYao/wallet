package com.xiamuyao.ulanbator.model.repository

import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.network.api.MyService
import com.xiamuyao.ulanbator.util.Md5
import com.xiamuyao.ulanbator.util.putSpValue
import com.xiamuyao.ulanbator.util.removeAllKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyUserRepository(private var myService: MyService) {

    /**
     * 获取用户信息
     */
    suspend fun getUserInformation() = withContext(Dispatchers.IO) {
        val provinces = myService.getUserInformation()
        val data = provinces.data
        if (provinces.result.returnCode == "0") {
            App.CONTEXT.putSpValue("nickname", data.nickname)
            App.CONTEXT.putSpValue("vipType", data.vipType)
            App.CONTEXT.putSpValue("tel", data.tel)
            App.CONTEXT.putSpValue("dialingCode", data.dialingCode)
            App.CONTEXT.putSpValue("inviteCode", data.inviteCode)
        }
        return@withContext myService.getUserInformation()
    }

    /**
     * 修改用户信息
     */
    suspend fun modifyUserInformation(nickname: String) = withContext(Dispatchers.IO) {
        val provinces = myService.modifyUserInformation(nickname)
        if (provinces.result.returnCode == "0") {
            App.CONTEXT.putSpValue("nickname", nickname)
        }
        return@withContext provinces
    }

    /**
     * 修改资金密码
     */
    suspend fun modifyTheFundPassword(
        password: String,
        passwordConfirm: String,
        verifyCode: String
    ) = withContext(Dispatchers.IO) {
        val provinces = myService.modifyTheFundPassword(Md5.getMD5(password), Md5.getMD5(passwordConfirm), verifyCode)
        return@withContext provinces
    }

    /**
     * 修改登录密码
     */
    suspend fun modifyTheLoginPassword(
        loginPassword: String,
        password: String,
        passwordConfirm: String,
        verifyCode: String
    ) = withContext(Dispatchers.IO) {
        val provinces = myService.modifyTheLoginPassword(
            Md5.getMD5(loginPassword),
            Md5.getMD5(password),
            Md5.getMD5(passwordConfirm),
            verifyCode
        )
        if (provinces.result.returnCode == "0") {
            App.CONTEXT.removeAllKey()
        }
        return@withContext provinces
    }

    companion object {

        private var instance: MyUserRepository? = null

        fun getInstance(myService: MyService): MyUserRepository {
            if (instance == null) {
                synchronized(MyUserRepository::class.java) {
                    if (instance == null) {
                        instance = MyUserRepository(myService)
                    }
                }
            }
            return instance!!
        }
    }
}