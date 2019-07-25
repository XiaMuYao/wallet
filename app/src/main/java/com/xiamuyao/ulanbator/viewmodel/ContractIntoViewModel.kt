package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.PairListBean

class ContractIntoViewModel(application: Application) : BaseViewModel(application) {

    var pariList = ObservableArrayList<PairListBean>()

    override fun initData() {
        val pairListBeanBTC = PairListBean()
        val pairListBeanETH = PairListBean()
        val pairListBeanETC = PairListBean()
        val pairListBeanLTC = PairListBean()
        val pairListBeanEOS = PairListBean()


        pairListBeanBTC.pairName = "BTC"
        pairListBeanETH.pairName = "ETH"
        pairListBeanETC.pairName = "ETC"
        pairListBeanLTC.pairName = "LTC"
        pairListBeanEOS.pairName = "EOS"

        pairListBeanBTC.pairid = "BTC"
        pairListBeanETH.pairid = "ETH"
        pairListBeanETC.pairid = "ETC"
        pairListBeanLTC.pairid = "LTC"
        pairListBeanEOS.pairid = "EOS"

        pariList.add(pairListBeanBTC)
        pariList.add(pairListBeanETH)
        pariList.add(pairListBeanETC)
        pariList.add(pairListBeanLTC)
        pariList.add(pairListBeanEOS)

    }

}