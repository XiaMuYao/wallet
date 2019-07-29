package com.xiamuyao.ulanbator.model.repository

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.model.bean.response.CityListBean
import com.xiamuyao.ulanbator.network.api.UserService
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
        verifyKey: String,
        verifyCode: String,
        inviteCode: String) = withContext(Dispatchers.IO) {

        return@withContext userService.registered(countryCode,dialingCode,tel,password,passwordConfirm,verifyKey,verifyCode,inviteCode)
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