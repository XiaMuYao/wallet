package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.PairListBean
import com.xiamuyao.ulanbator.model.bean.response.MoneyProudyInfoBean
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.util.TimeUtli
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import org.kodein.di.generic.instance

class ContractIntoViewModel(application: Application) : BaseViewModel(application) {
    private val repository: MoneyRepository by instance()

    var pariList = ObservableArrayList<PairListBean>()
    var shopTitle = MutableLiveData<String>()
    var productId = MutableLiveData<String>()
    var shouyiText = MutableLiveData<String>()
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

    var showbottomLastTitle = MutableLiveData<String>()

    //收益开始时间
    var earningsStartTime = MutableLiveData<String>()
    //收益到账时间
    var incomeArrivalTime = MutableLiveData<String>()
    //到期转入时间
    var dueTransferTime = MutableLiveData<String>()


    override fun initData() {

        earningsStartTime.value = TimeUtli.getTime()
        incomeArrivalTime.value = TimeUtli.checkOption(earningsStartTime.value!!, "next")
        dueTransferTime.value = TimeUtli.checkOption(earningsStartTime.value!!, "next")
    }

    fun getPageData(productId: String) {
        launch {
            val financialManagementDetails = repository.getFinancialManagementDetails(productId)
            businessHandler(financialManagementDetails) {
                if (financialManagementDetails.result.returnCode == "0") {
                    with(financialManagementDetails.data) {
                        type.value = stateType
                        usermoney.value = money
                        selectStr(intro)
                        setTitle(this)
                        listSymbolFrozen.forEach {
                            pariList.add(PairListBean(it.symbolName.toUpperCase(), it.amount, it.symbolType.toString()))
                        }
                        selectPairName.value = pariList[0].pairName
                        selectPairPrice.value = pariList[0].pairPrice
                        selectPairID.value = pariList[0].pairID
                        showPrice.value = "可用: " + pariList[0].pairPrice + " " + selectPairName.value

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
            shopTitle.value = "买入 定期${dataBean.leaveDay}天 月化 ${shouyiText.value}"

        }
    }

    /**
     * 剔除无用字符串
     */
    private fun selectStr(intro: String) {
        val split = intro.split("~")
        if (split.size == 1) {
            low.value = split[0].replace("门槛：", "").replace("\$", "")
        } else if (split.size == 2) {
            low.value = split[0].replace("门槛：", "").replace("\$", "")
            high.value = split[1].replace("门槛：", "").replace("\$", "")
        }
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
        launch {
            val buyingWealthManagementProducts =
                repository.buyingWealthManagementProducts(productId.value!!, inoutMoney.value!!, selectPairID.value!!)
            businessHandler(buyingWealthManagementProducts) {
                finishStatus.call()
            }
        }
    }
}