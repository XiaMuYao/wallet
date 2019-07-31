package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.getSpValue

class ManagingMoneyViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf("合约", "定存")
    var inviteCode = MutableLiveData<String>()
    override fun initData() {
        inviteCode.value = "ID:${App.CONTEXT.getSpValue("inviteCode", "")}"

    }

}