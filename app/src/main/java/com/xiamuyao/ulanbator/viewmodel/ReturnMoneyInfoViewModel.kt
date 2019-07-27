package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.ReturnMoneyInfoBean

class ReturnMoneyInfoViewModel(application: Application) : BaseViewModel(application) {

    var returnMoneyInfoHis = ObservableArrayList<ReturnMoneyInfoBean>()

    override fun initData() {

        for (i in 0..10) {
            returnMoneyInfoHis.add(ReturnMoneyInfoBean())
        }
    }

}