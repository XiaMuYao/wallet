package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.FindRepository
import org.kodein.di.generic.instance

class MessageListInfoViewModel(application: Application) : BaseViewModel(application) {

    var messageId = MutableLiveData<String>()
    var id = MutableLiveData<String>()
    private val repository: FindRepository by instance()

    override fun initData() {
        launch { repository.readInformation(id.value!!) }

    }


}