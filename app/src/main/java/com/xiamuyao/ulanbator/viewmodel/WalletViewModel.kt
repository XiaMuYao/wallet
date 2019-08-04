package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.TOKEN
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.BigDecimalUtils
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.util.RateUtli.getUSDTToExchangeRate
import com.xiamuyao.ulanbator.util.UsetUtli
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

    var calculationStatus = MutableLiveData<Boolean>()

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
        calculationStatus.value = true
    }

    override fun initData() {
        //获取资产总值
        getTheTotalValueOfTheAsset()
    }

    /**
     * 刷新货币
     */
    fun refreshCurrency() {

        priceToName.value = RateUtli.getSelectCurrency()
        initData()
    }

    /**
     * 获取资产总值
     */
    fun getTheTotalValueOfTheAsset() {
        launch {
            val theWalletAssetHomepage = repository.getTheWalletAssetHomepage()
            businessHandler(theWalletAssetHomepage) {
                theWalletAssetHomepage.data.let {
                    walletList.clear()
                    walletList.addAll(it.data.list)
                    //币种个数 一起转换USDT = BTC shuliang
                    inviteCode.value = UsetUtli.getUserId()
                    calculationStatus.value = false
                    setTheSumOfAssets()
                    calculationStatus.value = true
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
    fun setTheSumOfAssets() {
        LL.d("刷新资产总和")
        var tempSum = "0"
        var tempMoney = "0"

        for (that in walletList) {

            if (that.pariAmount == "0" || that.pariAmount.isEmpty()) {
                that.pariToPrice = "0"
            }

            //平台币使用汇率接口
            if (that.pairToName == TOKEN + "USDT") {
                for (it in RateUtli.getRateList()) {
                    if (it.rateName.startsWith(TOKEN)) {
                        //平台币转换 USDT
                        that.pairToUSDT =
                            BigDecimalUtils.mul(it.rate.replace(",", ""), that.pariAmount.replace(",", ""))
                        //USDT 转换 BTC
                        that.PairToBTC = USDTtoBtc(that.pairToUSDT)
                        //USDT 转计价货币
                        that.pariToPrice = USDTtoChangeRate(that.pairToUSDT)
                    }
                    //当前货币对toUSDT的价格
                    that.PairToUSDTPrice = it.rate
                }

            }
            //公链币种
            for (it in RateUtli.getPriceList()) {

                if (that.pairToName == it.pairAndToName) {
                    //当前货币 转 USDT
                    that.pairToUSDT =
                        BigDecimalUtils.mul(that.pariAmount.replace(",", ""), it.close)

                    //USDT 转 BTC
                    that.PairToBTC = USDTtoBtc(that.pairToUSDT)

                    //USDT 转计价货币
                    that.pariToPrice = USDTtoChangeRate(that.pairToUSDT)

                    //当前货币对toUSDT的价格
                    that.PairToUSDTPrice = it.close
                    break
                }

            }

            //保存当前汇率数据
            saveCurrentExchangeRateData(that)
            //计算比特总和
            if (that.PairToBTC.isEmpty()) {
                tempSum += 0
            } else {
                tempSum = BigDecimalUtils.add(tempSum, that.PairToBTC)
            }
            //计算计价货币综合价值
            if (that.pariToPrice.isNullOrEmpty()) {
                tempMoney += 0
            } else {
                tempMoney =
                    BigDecimalUtils.add(tempMoney, that.pariToPrice!!)

            }
        }

        LL.d("计算比特总和::$tempSum")
        LL.d("计算计价货币总和::$tempMoney")
        priceSum.value = tempSum.toBigDecimal().stripTrailingZeros().toPlainString()
        priceToPair.value = tempMoney.toBigDecimal().stripTrailingZeros().toPlainString()
    }

    /**
     * USDT 转 BTC
     */
    private fun USDTtoBtc(pairToUSDT: String): String {
        val toPlainString = BigDecimalUtils.div(pairToUSDT, RateUtli.BtcToUsdt())
        if (toPlainString.isEmpty()) return "0"
        return toPlainString
    }

    /**
     * USDT 转计价货币
     */
    private fun USDTtoChangeRate(pairToUSDT: String): String {
        val stripTrailingZeros = BigDecimalUtils.mul(pairToUSDT, getUSDTToExchangeRate())
        if (stripTrailingZeros.isEmpty()) return "0"
        return stripTrailingZeros
    }

    /**
     * 保存当前汇率数据
     */
    private fun saveCurrentExchangeRateData(that: WalletListBean) {

    }

}