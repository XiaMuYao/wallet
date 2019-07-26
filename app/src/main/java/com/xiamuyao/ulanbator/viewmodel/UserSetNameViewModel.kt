package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class UserSetNameViewModel(application: Application) : BaseViewModel(application) {

    var userName = MutableLiveData<String>()

    override fun initData() {

    }

    fun saveUserName() {

        finishStatus.call()
    }


    fun cleanName() {

        userName.value = ""
    }

}