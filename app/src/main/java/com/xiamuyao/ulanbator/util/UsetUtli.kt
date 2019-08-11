package com.xiamuyao.ulanbator.util

import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.utlis.getSpValue
import com.xiamuyao.ulanbator.utlis.putSpValue

object UsetUtli {

    private var userName = ""
    private var userId = ""


    fun getUserName(): String {
        return if (userName.isEmpty()) {
            val spValue = App.CONTEXT.getSpValue("nickname", "")
            userName = spValue
            userName

        } else {
            userName
        }
    }

    fun saveUserName(value: String) {
        App.CONTEXT.putSpValue("nickname", value)
        userName = value
    }

    fun getUserId(): String {
        return if (userId.isEmpty()) {
            val spValue = "ID:${App.CONTEXT.getSpValue("inviteCode", "")}"
            userId = spValue
            userId

        } else {
            userId
        }
    }

    fun saveUserId(value: String) {
        App.CONTEXT.putSpValue("inviteCode", value)
        userId = "ID:${value}"
    }
}