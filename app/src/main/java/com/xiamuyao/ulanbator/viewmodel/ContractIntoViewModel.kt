package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import android.graphics.Color
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.TOKEN
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.PairListBean
import com.xiamuyao.ulanbator.model.bean.response.MoneyProudyInfoBean
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.util.RateUtli.getPriceList
import com.xiamuyao.ulanbator.util.RateUtli.getRateList
import com.xiamuyao.ulanbator.util.TimeUtli
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.To
import org.kodein.di.generic.instance
import java.math.BigDecimal
import android.text.Spanned.SPAN_INCLUSIVE_EXCLUSIVE
import android.graphics.Color.parseColor
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan


class ContractIntoViewModel(application: Application) : BaseViewModel(application) {
    private val repository: MoneyRepository by instance()

    var pariList = ObservableArrayList<PairListBean>()
    var shopTitle = MutableLiveData<String>()
    var productId = MutableLiveData<String>()
    var shouyiText = MutableLiveData<String>()
    var from = MutableLiveData<String>()
    var low = MutableLiveData<String>()
    var high = MutableLiveData<String>()
    var usermoney = MutableLiveData<String>()
    //输入的钱
    var inoutMoney = MutableLiveData<String>()
    //计算后的钱
    var nowSelectPrice = MutableLiveData<String>()
    // 1 已认购
    // 2 已满额
    // 3 可认购
    var type = MutableLiveData<Int>()

    var loadOk = SingleLiveEvent<Boolean>()

    var selectPairName = MutableLiveData<String>()
    var selectPairPrice = MutableLiveData<String>()
    var selectPairID = MutableLiveData<String>()
    var showPrice = MutableLiveData<String>()
    var xiane = MutableLiveData<String>()
    var introintro = MutableLiveData<String>()

    var showbottomLastTitle = MutableLiveData<String>()

    //收益开始时间
    var earningsStartTime = MutableLiveData<String>()
    //收益到账时间
    var incomeArrivalTime = MutableLiveData<String>()
    //到期转入时间
    var dueTransferTime = MutableLiveData<String>()

    var yujishijian = MutableLiveData<String>()


    override fun initData() {
        low.value = "0"
        nowSelectPrice.value = "0"
        earningsStartTime.value = TimeUtli.getTime()
        incomeArrivalTime.value = TimeUtli.checkOption("next", earningsStartTime.value!!)


    }

    fun getPageData(productId: String) {
        launch {
            val financialManagementDetails = repository.getFinancialManagementDetails(productId)
            businessHandler(financialManagementDetails) {
                if (financialManagementDetails.result.returnCode == "0") {
                    with(financialManagementDetails.data) {
                        type.value = stateType
                        usermoney.value = money
                        setTitle(this)
                        listSymbolFrozen.forEach {
                            pariList.add(PairListBean(it.symbolName.toUpperCase(), it.amount, it.symbolType.toString()))
                        }


                        if (from.value == "2") {

                            val find = listSymbolFrozen.find { it.symbolName.toUpperCase() == TOKEN }
                            selectPairName.value = find?.symbolName?.toUpperCase()
                            selectPairPrice.value = find?.amount
                            selectPairID.value = find?.symbolType!!.toString()

                            dueTransferTime.value =
                                TimeUtli.checkOption("next", earningsStartTime.value!!, leaveRate.toInt())

                        } else {

                            selectPairName.value = pariList[0].pairName.toUpperCase()
                            selectPairPrice.value = pariList[0].pairPrice
                            selectPairID.value = pariList[0].pairID
                        }

                        setTitle1(0)
                        high.value = userAmountMaxSum
                        xiane.value =
                            intro.replace(context.getString(R.string.menkan), context.getString(R.string.xiane))
                        introintro.value = intro

                        loadOk.call()
                    }

                }
            }
        }
    }

    private fun setTitle(dataBean: MoneyProudyInfoBean.DataBean) {
        if (dataBean.title.contains("S")) {
            shopTitle.value = "买入 ${dataBean.title}合约 日化 ${shouyiText.value}"

        } else if (dataBean.title.contains("X")) {
            shopTitle.value = "买入 ${dataBean.intro} 月化 ${shouyiText.value}"

        }
    }

    /**
     * 投资额度
     */
    fun setTitle1(toInt: Int) {
        selectPairID.value = pariList[toInt].pairID
        showPrice.value = context.getString(R.string.keyong) + pariList[toInt].pairPrice + " " + selectPairName.value

    }

    /**
     * 全部转入
     */
    fun transferAll() {
        inoutMoney.value = selectPairPrice.value
    }

    /**
     * 接触合约
     */
    fun contactContract() {
        launch {
            val transfer = repository.transfer(productId.value!!)
            businessHandler(transfer) {
                finishStatus.call()
            }

        }
    }

    /**
     * 购买产品
     */
    fun buyProduct() {
        if (inoutMoney.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.inputNotNull))
            return
        }
        launch {
            val buyingWealthManagementProducts =
                repository.buyingWealthManagementProducts(productId.value!!, inoutMoney.value!!, selectPairID.value!!)
            businessHandler(buyingWealthManagementProducts) {
                finishStatus.call()
            }
        }
    }

    /**
     * 计算输入之后的金额
     */
    fun calculateTheAmountAfterTheInput(inputValue: BigDecimal) {

        for (it in getRateList()) {
            //如果是平台币
            if (selectPairName.value == TOKEN) {
                val TOKENUSDT = getRateList().find { it.rateName == "TOKENUSDT" }
                //平台币兑换USDT
                val tokenToUSDTPrice = inputValue.multiply(TOKENUSDT?.rate?.toBigDecimal()?.stripTrailingZeros())

                //USDT 兑换 USD
                val USDTUSD = getRateList().find { it.rateName == "USDTUSD" }
                val tokenToUSDT =
                    tokenToUSDTPrice.multiply(USDTUSD?.rate?.toBigDecimal()?.stripTrailingZeros()).toPlainString()
                nowSelectPrice.value = tokenToUSDT
                break

            } else {
                //汇率中得USDT
                val find = getRateList().find { it.rateName == "USDTUSD" }

                val find1 = getPriceList().find { it.pairAndToName == selectPairName.value?.toUpperCase() + "USDT" }

                if (null != find1) {

                    val tokenToUSDT =
                        inputValue.multiply(find1.close.toBigDecimal().stripTrailingZeros()).toPlainString()


                    val toPlainString =
//                        tokenToUSDT.toBigDecimal().multiply(find?.rate?.toBigDecimal()?.stripTrailingZeros())
//                            .toPlainString()
                        tokenToUSDT.toBigDecimal().div(find?.rate!!.toBigDecimal()).stripTrailingZeros().toPlainString()
//                    BigDecimalUtils.div(tokenToUSDT,find?.rate!!)

                    nowSelectPrice.value = toPlainString



                    break
                }


            }
        }
    }
}