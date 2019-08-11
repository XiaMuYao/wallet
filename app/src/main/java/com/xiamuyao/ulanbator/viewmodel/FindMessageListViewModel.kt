package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.FindMessageBean
import com.xiamuyao.ulanbator.model.repository.FindRepository
import org.kodein.di.generic.instance

class FindMessageListViewModel(application: Application) : BaseViewModel(application) {

    var findMessage = ObservableArrayList<FindMessageBean>()
    var requesttype = MutableLiveData<String>()

    private val repository: FindRepository by instance()


    override fun initData() {

        getList()
    }

    fun getList() {
        launch {
            val discoveryPageInformation = repository.getDiscoveryPageInformation(requesttype.value!!)
            findMessage.clear()
            findMessage.addAll(discoveryPageInformation)
        }
    }

}