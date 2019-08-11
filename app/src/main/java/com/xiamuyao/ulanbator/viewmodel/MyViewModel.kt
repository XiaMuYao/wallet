package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.util.UsetUtli
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.getSpValue
import org.kodein.di.generic.instance

class MyViewModel(application: Application) : BaseViewModel(application) {

    private val repository: MyUserRepository by instance()

    var nickName = MutableLiveData<String>()
    var vipType = MutableLiveData<Int>()
    var inviteCode = MutableLiveData<String>()



    override fun initData() {

        initUsetData()

        getUserInfo()
    }

    private fun initUsetData() {
        nickName.value =UsetUtli.getUserName()
        vipType.value = getSpValue("vipType", 1)
        inviteCode.value = UsetUtli.getUserId()
    }

    private fun getUserInfo() {
        launch {
            val userInformation = repository.getUserInformation()
            val data = userInformation.data

            businessHandler(userInformation) {
                nickName.value = data.nickname
                vipType.value = data.vipType
                inviteCode.value = "ID:${data.inviteCode}"
            }
        }

    }

}