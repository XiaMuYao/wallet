package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel

class FindViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf("公告", "资讯", "DAPP")


    override fun initData() {

    }

}