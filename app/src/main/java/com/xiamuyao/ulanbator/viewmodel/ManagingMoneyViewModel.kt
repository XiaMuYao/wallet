package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel

class ManagingMoneyViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf("合约", "定存")

    override fun initData() {

    }

}