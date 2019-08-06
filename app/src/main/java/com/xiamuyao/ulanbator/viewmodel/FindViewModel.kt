package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel

class FindViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf(App.CONTEXT.getString(R.string.zixun),App.CONTEXT.getString(R.string.gonggao))


    override fun initData() {

    }

}