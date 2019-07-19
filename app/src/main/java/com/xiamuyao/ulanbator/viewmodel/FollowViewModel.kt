package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.util.DataUtli
import com.xiamuyao.ulanbator.base.BaseViewModel

class FollowViewModel(application: Application) : BaseViewModel(application) {

    var skirtList = DataUtli.getSkirtList()


    override  fun initData() {
    }

}