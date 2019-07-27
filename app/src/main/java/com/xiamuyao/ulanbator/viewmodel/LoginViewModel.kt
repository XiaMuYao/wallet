package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class LoginViewModel(application: Application) : BaseViewModel(application) {

    var selectCityName = MutableLiveData<String>()
    var selectCityNum = MutableLiveData<String>()

    init {
        selectCityNum.value = "+86"
        selectCityName.value = "韩国"
    }
    override fun initData() {

    }

}