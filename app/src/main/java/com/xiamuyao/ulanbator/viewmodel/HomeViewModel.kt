package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.base.BaseViewModel
import org.kodein.di.generic.instance

class HomeViewModel(application: Application) : BaseViewModel(application) {

    private val repository: PlaceRepository by instance()

    val titleList = arrayListOf("关注", "推荐")

    override  fun initData() {


    }


}