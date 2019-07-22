package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.util.DataUtli
import com.xiamuyao.ulanbator.base.BaseViewModel

class TopViewModel(application: Application) : BaseViewModel(application) {

    var skirtList = DataUtli.getSkirtList()
    var topPageTopList =DataUtli.getTopMessage()

    override  fun initData() {
    }

}