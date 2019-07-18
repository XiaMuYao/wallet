package com.xiamuyao.sample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.sample.model.bean.WanAndroidBean
import com.xiamuyao.sample.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import org.kodein.di.generic.instance

class MyViewModel(application: Application) : BaseViewModel(application) {

    private val repository: PlaceRepository by instance()

    var mylist: MutableLiveData<MutableList<WanAndroidBean.DataBean>> = MutableLiveData()

    override fun initData() {

        launch {
            val result = businessHandler(repository.getProvinceListAsync())
            mylist.value = result
        }

    }


}