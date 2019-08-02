package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import android.icu.util.UniversalTimeScale.toBigDecimal
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.TOKEN
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.utlis.LL
import org.kodein.di.generic.instance

class WalletViewModel(application: Application) : BaseViewModel(application) {

    private val repository: WalletRepository by instance()

    val walletList = ObservableArrayList<WalletListBean>()

    var showOrHide = MutableLiveData<Boolean>()

    var priceSum = MutableLiveData<String>()
    var priceToPair = MutableLiveData<String>()
    var priceToName = MutableLiveData<String>()
    var priceName = MutableLiveData<String>()
    var inviteCode = MutableLiveData<String>()

    init {
        showOrHide.value = true
        priceSum.value = "0"
        priceToPair.value = "0"
        //todo 计价货币抽出来
        priceToName.value = RateUtli.getSelectCurrency()
        //固定BTC
        priceName.value = "BTC"
        //用户ID
        inviteCode.value = "ID:999999"
    }

    override fun initData() {
        //获取资产总值
        getTheTotalValueOfTheAsset()
    }

    /**
     * 计算资产折合法币
     */
    fun calculateAssets() {

    }

    /**
     * 获取资产总值
     */
    fun getTheTotalValueOfTheAsset() {
        launch {
            val theWalletAssetHomepage = repository.getTheWalletAssetHomepage()
            businessHandler(theWalletAssetHomepage) {
                theWalletAssetHomepage.data.let {
                    walletList.addAll(it.data.list)
                    //币种个数 一起转换USDT = BTC shuliang
//                    priceSum.value = USDTtoBtc(it.data.userSumMoney)
                    inviteCode.value = "ID:${App.CONTEXT.getSpValue("inviteCode", "")}"
                    calculateAssets()
                }
            }
        }
    }


    fun showOrHideListData() {
        walletList.forEach {
            it.showHide = showOrHide.value!!
        }
    }

    /**
     * 刷新资产总和
     */
    @Synchronized
    fun setTheSumOfAssets() {
        LL.d("刷新资产总和")
        var tempSum = "0"
        var tempMoney = "0"
        walletList.forEach { that ->
            if (that.pariAmount == "0" || that.pariAmount.isEmpty()) {
                that.pariToPrice = "0"
                return@forEach
            }
//            //平台币使用汇率接口
            if (that.pairToName == TOKEN + "USDT") {
                RateUtli.getRateList().forEach {
                    if (it.rateName.startsWith(TOKEN)) {
                        //todo 科学计数法得问题
                        //平台币转换 USDT
                        that.pairToUSDT =
                            it.rate.replace(",", "").toBigDecimal()
                                .multiply(that.pariAmount.replace(",", "").toBigDecimal()).stripTrailingZeros()
                                .toPlainString()
                        //USDT 转换 BTC
                        that.PairToBTC = USDTtoBtc(that.pairToUSDT)
                        that.pariToPrice = USDTtoChangeRate(that.pairToUSDT)
                    }
                    return@forEach
                }
            }
            //公链币种
            RateUtli.getPriceList().forEach {
                if (that.pairToName == it.pairAndToName) {
                    //当前货币 转 USDT
                    that.pairToUSDT =
                        that.pariAmount.replace(",", "").toBigDecimal().multiply(it.close.toBigDecimal())
                            .stripTrailingZeros().toPlainString()

                    //USDT 转 BTC
                    that.PairToBTC = USDTtoBtc(that.pairToUSDT)

                    //USDT 转计价货币
                    that.pariToPrice = USDTtoChangeRate(that.pairToUSDT)

                    return@forEach
                }
            }
            //计算比特总和
            if (that.PairToBTC.isEmpty()) {
                tempSum += 0
            } else {
                tempSum = tempSum.toBigDecimal().add(that.PairToBTC.toBigDecimal()).toPlainString()
            }
            //计算计价货币综合价值
            if (that.pariToPrice.isNullOrEmpty()) {
                tempMoney += 0
            } else {
                tempMoney = tempMoney.toBigDecimal().add(that.pariToPrice?.toBigDecimal()).toPlainString()

            }
        }
        LL.d("计算比特总和::$tempSum")
        LL.d("计算计价货币总和::$tempMoney")
        priceSum.value = tempSum
        priceToPair.value = tempMoney
    }

    /**
     * USDT 转 BTC
     */
    private fun USDTtoBtc(pairToUSDT: String): String {
        val toPlainString = pairToUSDT.toBigDecimal().div(RateUtli.BtcToUsdt().toBigDecimal()).stripTrailingZeros()
            .toPlainString()
        if (toPlainString.isEmpty()) return "0"
        return toPlainString
    }

    /**
     * USDT 转计价货币
     */
    private fun USDTtoChangeRate(pairToUSDT: String): String {
        val stripTrailingZeros =
            pairToUSDT.toBigDecimal().multiply(ProjectConstant.USDTToExchangeRate.toBigDecimal()).stripTrailingZeros()
                .toPlainString()
        if (stripTrailingZeros.isEmpty()) return "0"
        return stripTrailingZeros
    }


}