package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.ContractListBean
import com.xiamuyao.ulanbator.model.bean.FixedListBean

class FixedDepositFragmentViewModel(application: Application) : BaseViewModel(application) {

    var fixedList = ObservableArrayList<FixedListBean>()


    override fun initData() {

        getFixedList()
    }

    private fun getFixedList() {
        for (i in 1..10) {
            fixedList.add(FixedListBean())
        }
    }

}