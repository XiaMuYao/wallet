package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant.IMAGE_URL
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import org.kodein.di.generic.instance

class WalletViewModel(application: Application) : BaseViewModel(application) {

    private val repository: PlaceRepository by instance()

    val walletList = ObservableArrayList<WalletListBean>()

    var showOrHide = MutableLiveData<Boolean>()

    var priceSum = MutableLiveData<String>()
    var priceToPair = MutableLiveData<String>()
    var priceToName = MutableLiveData<String>()
    var priceName = MutableLiveData<String>()

    init {
        showOrHide.value = true
        priceSum.value = "321.123.1244"
        priceToPair.value = "4334432.34"
        priceToName.value = "CNY"
        priceName.value = "BTC"
    }

    override fun initData() {
        for (i in 0..10) {
            val walletListBean = WalletListBean()
            with(walletListBean) {
                id = i
                pairName = "BTC"
                pairImage = IMAGE_URL
                pairToName = "LTC"
                pariPrice = "12311312"
                pariToPrice = "0"
                showHide = true
            }
            walletList.add(walletListBean)
        }
    }

    fun showOrHideListData() {
        walletList.forEach {
            it.showHide = showOrHide.value!!
        }
    }

}