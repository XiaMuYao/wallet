package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class MessageListInfoViewModel(application: Application) : BaseViewModel(application) {

    var messageId = MutableLiveData<String>()
    var messageBody = MutableLiveData<String>()

    override fun initData() {

    }

    fun getPageData() {
        messageBody.value = "454546544546544546544546544546544546544654"
    }

}