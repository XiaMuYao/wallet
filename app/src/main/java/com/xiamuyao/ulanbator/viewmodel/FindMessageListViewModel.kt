package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.FindMessageBean

class FindMessageListViewModel(application: Application) : BaseViewModel(application) {

    var findMessage = ObservableArrayList<FindMessageBean>()

    override fun initData() {
        for (i in 0..10) {
            findMessage.add(FindMessageBean())
        }
    }

}