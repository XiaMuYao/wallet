package com.xiamuyao.ulanbator.model.repository

import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.network.api.MyService
import com.xiamuyao.ulanbator.util.Md5
import com.xiamuyao.ulanbator.util.UsetUtli
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
            UsetUtli.saveUserName(data.nickname)
            App.CONTEXT.putSpValue("vipType", data.vipType)
            App.CONTEXT.putSpValue("tel", data.tel)
            App.CONTEXT.putSpValue("dialingCode", data.dialingCode)
            UsetUtli.saveUserId(data.inviteCode)
        }
        return@withContext myService.getUserInformation()
    }

    /**
     * 修改用户信息
     */
    suspend fun modifyUserInformation(nickname: String) = withContext(Dispatchers.IO) {
        val provinces = myService.modifyUserInformation(nickname)
        if (provinces.result.returnCode == "0") {
            UsetUtli.saveUserName(nickname)
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

    /**
     * 获取邀请返佣统计
     */
    suspend fun getInvitationRebateStatistics() = withContext(Dispatchers.IO) {
        val provinces = myService.getInvitationRebateStatistics()
        if (provinces.result.returnCode == "0") {
            val sumBy = provinces.data.list.sumBy { it.vipQty.toInt() }
            if (sumBy > 0) {
                val i = provinces.data.userQtyALL.toInt() - sumBy
                provinces.data.sum = i.toString()
            }
        }
        return@withContext provinces
    }

    /**
     * 获取邀请记录
     */
    suspend fun getTheInvitationRecord(start: String, index: String) = withContext(Dispatchers.IO) {
        val provinces = myService.getTheInvitationRecord(start, index)
        if (provinces.result.returnCode == "0") {
        }
        return@withContext provinces
    }

    /**
     * 获取返佣记录
     */
    suspend fun getARebateRecord(start: String, index: String) = withContext(Dispatchers.IO) {
        val provinces = myService.getARebateRecord(start, index)
        if (provinces.result.returnCode == "0") {
        }
        return@withContext provinces
    }

    /**
     * 获取返佣详情
     */
    suspend fun getRebateDetails(inviteCode: String, start: String, index: String) = withContext(Dispatchers.IO) {
        val provinces = myService.getRebateDetails(inviteCode, start, index)
        if (provinces.result.returnCode == "0") {
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