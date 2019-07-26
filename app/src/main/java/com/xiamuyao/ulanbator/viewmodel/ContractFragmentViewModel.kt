package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.model.bean.ContractListBean

class ContractFragmentViewModel(application: Application) : BaseViewModel(application) {

    var contractList = ObservableArrayList<ContractListBean>()

    override fun initData() {

        getContractList()
    }

    private fun getContractList() {
        for (i in 1..8) {
            val contractListBean = ContractListBean()
            contractList.add(contractListBean)
        }
    }

}