package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.util.getSpValue
import org.kodein.di.generic.instance

class ManagingMoneyViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf("合约", "定存")
    var inviteCode = MutableLiveData<String>()
    var sum = MutableLiveData<String>()

    private val repository: MoneyRepository by instance()

    override fun initData() {
        inviteCode.value = "ID:${App.CONTEXT.getSpValue("inviteCode", "")}"

        getfinancialHomeInformation()
    }

    /**
     * 理财首页信息
     */
    fun getfinancialHomeInformation() {
        launch {
            val financialHomeInformation = repository.financialHomeInformation()
            businessHandler(financialHomeInformation) {
                sum.value = financialHomeInformation.data.sum
                inviteCode.value = "ID:${financialHomeInformation.data.inviteCode}"
            }
        }
    }
}