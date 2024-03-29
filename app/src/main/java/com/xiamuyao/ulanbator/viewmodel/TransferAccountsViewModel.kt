package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.activity.SendInfoActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.BigDecimalUtils
import com.xiamuyao.ulanbator.util.UsetUtli
import com.xiamuyao.ulanbator.utlis.getSpValue

class TransferAccountsViewModel(application: Application) : BaseViewModel(application) {

    var nickName = MutableLiveData<String>()
    var inviteCode = MutableLiveData<String>()
    var vipType = MutableLiveData<Int>()

    var pairType = MutableLiveData<String>()
    var pairName = MutableLiveData<String>()

    //最大最小手续费
    var symbolFeeMax = MutableLiveData<String>()
    var symbolFeeMin = MutableLiveData<String>()

    var type = MutableLiveData<Boolean>()

    var address = MutableLiveData<String>()
    var money = MutableLiveData<String>()
    var memoAddress = MutableLiveData<String>()
    var userSymbolFeeRate = MutableLiveData<String>()

    //手续费
    var msymbolFeeRate = MutableLiveData<String>()
    //可用余额
    var mbalance = MutableLiveData<String>()


    override fun initData() {
        userSymbolFeeRate.value = "0"
        nickName.value = UsetUtli.getUserName()
        vipType.value = getSpValue("vipType", 1)
        inviteCode.value = UsetUtli.getUserId()

    }

    /**
     * 计算手续费
     */
    fun calculationFee() {
        if (money.value.isNullOrEmpty()) {
            userSymbolFeeRate.value = ""
            return
        }

        val run = BigDecimalUtils.run { mul(msymbolFeeRate.value!!.replace(",", ""), "0.01") }
        val mul = BigDecimalUtils.mul(money.value?.replace(",", "")!!, run)
        
        if (BigDecimalUtils.compare(mul, symbolFeeMax.value!!)) {
            userSymbolFeeRate.value = symbolFeeMax.value!!.toBigDecimal().stripTrailingZeros().toPlainString()
            return
        } else if (!BigDecimalUtils.compare(mul, symbolFeeMin.value!!)) {
            userSymbolFeeRate.value = symbolFeeMin.value!!.toBigDecimal().stripTrailingZeros().toPlainString()
            return
        }
        userSymbolFeeRate.value = mul.toBigDecimal().stripTrailingZeros().toPlainString()

    }

    fun allIn() {
        money.value = mbalance.value?.replace(",","")
        calculationFee()
    }

    fun sendInfo() {
        startActivity(
            SendInfoActivity::class.java,
            bundleOf
                (
                "money" to money.value,
                "address" to address.value,
                "memoAddress" to memoAddress.value,
                "userSymbolFeeRate" to userSymbolFeeRate.value,
                "pairName" to pairName.value,
                "pairType" to pairType.value,
                "type" to type.value
            )
        )
    }
}