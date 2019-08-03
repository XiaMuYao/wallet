package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.util.RateUtli.SaveSelectCurrency
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.LL

class SelectPairViewModel(application: Application) : BaseViewModel(application) {

    var pairList = arrayListOf<String>("CNY", "USD", "JPY", "KRW")

    var slectIndex = MutableLiveData<Int>()

    override fun initData() {
        for ((index, data) in pairList.withIndex()) {

            if (data == getSelectCurrency()) {
                slectIndex.value = index
                break
            }

        }


    }

    /**
     * 保存计价货币
     */
    fun saveTheCurrency(value: Int) {
        val s = pairList[value]
        SaveSelectCurrency(s)
        DataBus.postData(EventConstant.valuationCurrencyRefresh,"")
        finishStatus.call()
    }
}