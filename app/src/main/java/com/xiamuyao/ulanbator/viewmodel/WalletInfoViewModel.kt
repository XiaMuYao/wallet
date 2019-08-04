package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.core.os.bundleOf
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.activity.InMoneyActivity
import com.xiamuyao.ulanbator.activity.TransferAccountsActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.bean.WalletListInfoBean
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.BigDecimalUtils
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency
import com.xiamuyao.ulanbator.util.RateUtli.getUSDTToExchangeRate
import com.xiamuyao.ulanbator.util.toTime
import org.kodein.di.generic.instance

class WalletInfoViewModel(application: Application) : BaseViewModel(application) {
    var walletInfo = ObservableArrayList<WalletListInfoBean>()

    var walletListBean = MutableLiveData<WalletListBean>()

    //可用
    var available = MutableLiveData<String>()
    //可用价格
    var availablePrice = MutableLiveData<String>()
    //冻结
    var freeze = MutableLiveData<String>()
    //冻结价格
    var freezePrice = MutableLiveData<String>()
    //计价货币
    var pricingCurrency = MutableLiveData<String>()
    //手续费
    var msymbolFeeRate = MutableLiveData<String>()
    //可用余额
    var mbalance = MutableLiveData<String>()

    private val repository: WalletRepository by instance()


    override fun initData() {
        pricingCurrency.value = getSelectCurrency()
        //当前货币 兑换方USDT 的价格
        currentCurrencyExchangeCurrency()
    }

    /**
     * 当前货币兑换法币
     */
    private fun currentCurrencyExchangeCurrency() {
        if (walletListBean.value?.pariAmount.isNullOrEmpty() || walletListBean.value?.pariAmount == "0") return
        walletListBean.value?.pairToUSDT =
            BigDecimalUtils.div(walletListBean.value?.pariToPrice!!, walletListBean.value?.pariAmount!!)
    }

    fun getPageData() {

        launch {

            val walletInPageTransactionHistory =
                repository.getWalletInPageTransactionHistory(
                    walletListBean.value?.pariId!!,
                    "0",
                    Int.MAX_VALUE.toString()
                )

            businessHandler(walletInPageTransactionHistory) {
                with(walletInPageTransactionHistory.data) {
                    available.value = balance
                    freeze.value = frozen
                    msymbolFeeRate.value = symbolFeeRate
                    mbalance.value = balance

                    availablePrice.value = currentCurrencyPairCurrency(available.value!!.replace(",", ""))
                    freezePrice.value = currentCurrencyPairCurrency(freeze.value!!.replace(",", ""))

                    list.forEach {
                        val walletListInfoBean = WalletListInfoBean()
                        walletListInfoBean.money = it.amount
                        walletListInfoBean.time = it.createTime.toTime()!!
                        walletListInfoBean.state = it.memo
                        walletListInfoBean.title = it.operationTypeText
                        walletListInfoBean.pair = walletListBean.value?.pairName!!
                        walletInfo.add(walletListInfoBean)
                    }

                }
            }

        }
    }

    /**
     * 当前货币对计价货币
     */
    fun currentCurrencyPairCurrency(value: String): String {
        val multiply =
            BigDecimalUtils.mul(value, walletListBean.value?.PairToUSDTPrice!!)
        val toPlainString =
            BigDecimalUtils.mul(multiply, getUSDTToExchangeRate())
        return toPlainString + " " + pricingCurrency.value
    }

    /**
     * 收款
     */
    fun receipt() {
        startActivity(
            InMoneyActivity::class.java,
            bundleOf("pairType" to walletListBean.value?.pariId, "pairName" to walletListBean.value?.pairName)
        )
    }

    /**
     * 转账
     */
    fun transfer() {
        var type = false
        type = walletListBean.value?.pairName?.toString()?.contains("EOS")!!
        startActivity(
            TransferAccountsActivity::class.java, bundleOf(
                "pairType" to walletListBean.value?.pariId,
                "pairName" to walletListBean.value?.pairName,
                "msymbolFeeRate" to msymbolFeeRate.value,
                "balance" to mbalance.value,
                "type" to type
            )
        )
    }

}