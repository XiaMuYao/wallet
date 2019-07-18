package com.xiamuyao.sample.viewmodel

import android.app.Application
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.R
import com.xiamuyao.sample.util.DataUtli
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter

class FollowViewModel(application: Application) : BaseViewModel(application) {

    var skirtList = DataUtli.getSkirtList()


    override  fun initData() {
    }

}