package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.WalletListInfoBean

class WalletInfoViewModel(application: Application) : BaseViewModel(application) {
    var walletInfo = ObservableArrayList<WalletListInfoBean>()

    override fun initData() {
        for (i in 0..10) {
            walletInfo.add(WalletListInfoBean())
        }
    }

}