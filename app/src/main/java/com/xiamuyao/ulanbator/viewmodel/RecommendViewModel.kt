package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.DataUtli

class RecommendViewModel(application: Application) : BaseViewModel(application) {

    val hotCommunity = DataUtli.getHotCommunity()
    val topMessage = DataUtli.getTopMessage()

    var skirtList = DataUtli.getSkirtList()

    override fun initData() {

    }



}