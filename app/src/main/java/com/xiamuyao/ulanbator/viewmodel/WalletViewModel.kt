package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.getSpValue
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
        priceSum.value = ""
        priceToPair.value = ""
        //todo 计价货币抽出来
        priceToName.value = "CNY"
        //固定BTC
        priceName.value = "BTC"
        //用户ID
        inviteCode.value = "ID:999999"
    }

    override fun initData() {
        //获取资产总值
        getTheTotalValueOfTheAsset()
        //获取汇率数据
//        getExchangeRateData()
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
                    priceSum.value = it.data.userSumMoney
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

}