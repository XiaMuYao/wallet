package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.ReturnMoneyHisBean

class ReturnMoneyHisViewModel(application: Application) : BaseViewModel(application) {

    var returnMoneyHis = ObservableArrayList<ReturnMoneyHisBean>()

    override fun initData() {

        for (i in 0..10) {
            returnMoneyHis.add(ReturnMoneyHisBean())
        }
    }

}