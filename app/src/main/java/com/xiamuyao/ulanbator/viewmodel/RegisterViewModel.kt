package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.To

class RegisterViewModel(application: Application) : BaseViewModel(application) {

    var settingMoney = SingleLiveEvent<Int>()

    var registerSelect = MutableLiveData<Boolean>()

    init {
        registerSelect.value = false
    }

    override fun initData() {

    }

    fun registerUse() {
        if (!registerSelect.value!!) {
            To.showToast(context.getString(R.string.agranRegister))
            return
        }
        settingMoney.call()

    }

    fun selectRegister() {
        registerSelect.value = registerSelect.value?.not()
    }
}