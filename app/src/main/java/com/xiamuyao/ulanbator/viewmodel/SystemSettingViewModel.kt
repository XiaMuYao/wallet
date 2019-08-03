package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency

class SystemSettingViewModel(application: Application) : BaseViewModel(application) {

    var selectPair = MutableLiveData<String>()

    override fun initData() {

        selectPair.value = getSelectCurrency()
    }

}