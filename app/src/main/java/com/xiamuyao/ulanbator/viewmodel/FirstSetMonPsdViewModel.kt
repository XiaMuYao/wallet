package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent

class FirstSetMonPsdViewModel(application: Application) : BaseViewModel(application) {

    var gotoMainActivity = SingleLiveEvent<Boolean>()
    override fun initData() {

    }

    fun gotoMainActivity(){
        gotoMainActivity.call()
    }
}