package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import org.kodein.di.generic.instance

class MyViewModel(application: Application) : BaseViewModel(application) {

    private val repository: PlaceRepository by instance()


    override fun initData() {


    }

}