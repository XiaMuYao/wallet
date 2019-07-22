package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel

class FindViewModel(application: Application) : BaseViewModel(application) {

    val titleList = arrayListOf("推荐社区", "热门社区")


    override  fun initData() {

    }

}