package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel

class NoLoginViewModel(application: Application) : BaseViewModel(application) {

    var videoUrl = "android.resource://${context.packageName}/${R.raw.nologin}"
    override fun initData() {

    }

}