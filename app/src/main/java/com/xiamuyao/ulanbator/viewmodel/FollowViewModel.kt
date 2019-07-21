package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.DataUtli

class FollowViewModel(application: Application) : BaseViewModel(application) {

    var skirtList = DataUtli.getSkirtList()
    var parentIndex = -1


    override  fun initData() {
    }

}