package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.SetName
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.utlis.DataBus
import org.kodein.di.generic.instance

class UserSetNameViewModel(application: Application) : BaseViewModel(application) {

    var userName = MutableLiveData<String>()

    private val repository: MyUserRepository by instance()


    override fun initData() {

    }

    fun saveUserName() {

        launch {
            val modifyUserInformation = repository.modifyUserInformation(userName.value.toString())
            businessHandler(modifyUserInformation) {
                if (modifyUserInformation.result.returnCode=="0"){
                    DataBus.postData(SetName,"")
                    finishStatus.call()
                }
            }
        }
    }


    fun cleanName() {
        userName.value = ""
    }

}