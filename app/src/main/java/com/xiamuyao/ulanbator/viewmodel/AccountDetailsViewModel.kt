package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.util.businessHandler
import org.kodein.di.generic.instance

class AccountDetailsViewModel(application: Application) : BaseViewModel(application) {

    private val repository: MoneyRepository by instance()

    //昨日邀请收益
    var interestShareLast = MutableLiveData<String>()
    //累积总收益
    var interestALL = MutableLiveData<String>()
    //昨日总收益
    var interestLast = MutableLiveData<String>()
    //累积邀请收益
    var interestShare = MutableLiveData<String>()
    //累积理财收益
    var interestProduct = MutableLiveData<String>()
    //累积经纪人收益
    var interestTeam = MutableLiveData<String>()
    //昨日理财收益
    var interestProductLast = MutableLiveData<String>()

    override fun initData() {

        getFinancialAccountDetails()
    }

    /**
     * 理财首页信息
     */
    fun getFinancialAccountDetails() {
        launch {
            val getFinancialAccountDetails = repository.getFinancialAccountDetails()
            businessHandler(getFinancialAccountDetails) {
                interestShareLast .value = getFinancialAccountDetails.data.interestShareLast+"   MTF"
                interestALL.value = getFinancialAccountDetails.data.interestALL
                interestLast.value = getFinancialAccountDetails.data.interestLast +"   MFT"
                interestShare.value = getFinancialAccountDetails.data.interestShare
                interestProduct.value = getFinancialAccountDetails.data.interestProduct
                interestTeam.value = getFinancialAccountDetails.data.interestTeam
                interestProductLast.value = getFinancialAccountDetails.data.interestProductLast+"   MFT"
            }
        }
    }
}