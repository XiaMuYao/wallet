package com.xiamuyao.ulanbator.model.repository

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.model.dd
import com.xiamuyao.ulanbator.network.api.UserService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private var userService: UserService) {

    suspend fun getCityList() = withContext(Dispatchers.IO) {
        val tempList = ObservableArrayList<dd.DataBean.ListBean>()
        val cityList = userService.getCityList()
//        if (!cityList.result.returnCode.equals("0")) return@withContext
        tempList.addAll(cityList.data)
        return@withContext tempList
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