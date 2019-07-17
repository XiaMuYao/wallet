package com.xiamuyao.sample.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.sample.model.bean.WanAndroidBean
import com.xiamuyao.sample.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.base.BaseViewModel
import org.kodein.di.generic.instance

class MyViewModel(application: Application) : BaseViewModel(application) {
    private val repository: PlaceRepository by instance()

    var mylist = ObservableArrayList<WanAndroidBean.DataBean>()

    var mylistmylist = repository.testLiveData()

    override fun initData() {
        launch {
//            mylist.addAll(repository.getProvinceList().data!!)
        }
    }


}