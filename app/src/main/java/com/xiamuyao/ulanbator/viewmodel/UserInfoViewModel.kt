package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class UserInfoViewModel(application: Application) : BaseViewModel(application) {

    var userName = MutableLiveData<String>()

    init {
        userName.value = "Benjamin"
    }

    override fun initData() {

    }

}