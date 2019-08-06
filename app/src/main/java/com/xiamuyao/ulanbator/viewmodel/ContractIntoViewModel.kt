package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
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
import com.blankj.utilcode.util.TimeUtils
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.util.ArithUtil
import com.xiamuyao.ulanbator.util.BigDecimalUtils


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
    var usermoneyjindu = MutableLiveData<Int>()
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
    var thisleaveDay = MutableLiveData<String>()
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

    override fun initData() {
        low.value = "0"
        nowSelectPrice.value = "0"
        earningsStartTime.value = TimeUtli.checkOption("next", TimeUtli.getTime())

        incomeArrivalTime.value = TimeUtli.checkOption("next", TimeUtli.getTime(), 2)


    }

    fun getPageData(productId: String) {
        launch {
            val financialManagementDetails = repository.getFinancialManagementDetails(productId)
            businessHandler(financialManagementDetails) {
                if (financialManagementDetails.result.returnCode == "0") {
                    with(financialManagementDetails.data) {
                        type.value = stateType
                        usermoney.value = money
                        usermoneyjindu.value = stateRate
                        setTitle(this)
                        listSymbolFrozen.forEach {
                            pariList.add(PairListBean(it.symbolName.toUpperCase(), it.amount, it.symbolType.toString()))
                        }

                        thisleaveDay.value = leaveDay

                        if (from.value == "2") {

                            var index = -1
                            for ((indexx, data) in listSymbolFrozen.withIndex()) {
                                if (data.symbolName.toUpperCase() == TOKEN) {
                                    index = indexx
                                    break
                                }
                            }

                            val millis2String = TimeUtils.millis2String(System.currentTimeMillis())
                            dueTransferTime.value =
                                TimeUtli.checkOptionAll("next", millis2String, thisleaveDay.value?.toInt()!!)

                            setTitle1(index)

                        } else {

                            setTitle1(0)

                        }

                        high.value = userAmountMaxSum
                        xiane.value = context.getString(R.string.xianexx) + "$$userAmountMin ~ $$userAmountMax"
                        introintro.value = intro

                        loadOk.call()
                    }

                }
            }
        }
    }

    private fun setTitle(dataBean: MoneyProudyInfoBean.DataBean) {


        if (dataBean.title.contains("S")) {
            shopTitle.value =
                "${App.CONTEXT.getString(R.string.maorururu)} ${dataBean.title}${App.CONTEXT.getString(R.string.heyueheyue)} ${App.CONTEXT.getString(
                    R.string.rihuarihua
                )} ${shouyiText.value}"

        } else if (dataBean.title.contains("X")) {
            shopTitle.value =
                "${App.CONTEXT.getString(R.string.maorururu)} ${dataBean.intro} ${App.CONTEXT.getString(R.string.yuehuayuehua)} ${shouyiText.value}"

        }


    }

    /**
     * 投资额度
     */
    fun setTitle1(toInt: Int) {

        val pairListBean = pariList[toInt]

        selectPairID.value = pairListBean.pairID
        showPrice.value = context.getString(R.string.keyong) + pairListBean.pairPrice + " " + pairListBean.pairName

        selectPairName.value = pairListBean.pairName.toUpperCase()
        selectPairPrice.value = pairListBean.pairPrice
        selectPairID.value = pairListBean.pairID
    }

    /**
     * 全部转入
     */
    fun transferAll() {
        inoutMoney.value = selectPairPrice.value?.replace(",", "")
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
                val TOKENUSDT = getPriceList().find { it.pairName == TOKEN + "KRWT" }
                //平台币兑换KRWT
                val tokenToKRWTPrice =
                    inputValue.multiply(TOKENUSDT?.close?.toBigDecimal()?.stripTrailingZeros()).toPlainString()
                //查找usdt to 韩元
                val USDTKRW = getRateList().find { it.rateName == "USDT" + "KRW" }
                //USDT
                val KRWTToUSDTPrice = BigDecimalUtils.div(tokenToKRWTPrice, USDTKRW?.rate!!)

                //USDT 兑换 USD
                val USDTUSD = getRateList().find { it.rateName == "USDTUSD" }
                val tokenToUSDT =
                    KRWTToUSDTPrice.toBigDecimal().multiply(USDTUSD?.rate?.toBigDecimal()?.stripTrailingZeros())
                        .toPlainString()
                nowSelectPrice.value = ArithUtil.convertNumber3(tokenToUSDT, 2)

                break

            } else {
                //汇率中得USDT
                val find = getRateList().find { it.rateName == "USDTUSD" }

                val find1 = getPriceList().find { it.pairAndToName == selectPairName.value?.toUpperCase() + "USDT" }

                if (null != find1) {

                    val tokenToUSDT =
                        inputValue.multiply(find1.close.toBigDecimal().stripTrailingZeros()).toPlainString()


                    val toPlainString =
                        tokenToUSDT.toBigDecimal().div(find?.rate!!.toBigDecimal()).stripTrailingZeros().toPlainString()

                    nowSelectPrice.value = ArithUtil.convertNumber3(toPlainString, 2)

                    break
                }


            }
        }
    }
}