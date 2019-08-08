package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.util.BigDecimalUtils
import com.xiamuyao.ulanbator.util.RateUtli.getRateList
import com.xiamuyao.ulanbator.util.UsetUtli
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.util.getSpValue
import org.kodein.di.generic.instance

class ManagingMoneyViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf(context.getString(R.string.heyutitle), context.getString(R.string.dingcuntitle))
    var inviteCode = MutableLiveData<String>()
    var sum = MutableLiveData<String>()
    var priceSum = MutableLiveData<String>()

    private val repository: MoneyRepository by instance()

    override fun initData() {
        inviteCode.value = UsetUtli.getUserId()

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
                //计算USDToBTC
                calculateUSDToBTC()
            }
        }
    }

    /**
     * 计算USDToBTC
     */
    fun calculateUSDToBTC() {
        val find = getRateList().find { it.rateName == "BTCUSD" }
        val div = BigDecimalUtils.div(sum.value!!, find?.rate!!)

        priceSum.value = div

    }
}