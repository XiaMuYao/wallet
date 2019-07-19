package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.model.bean.WanAndroidBean
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import org.kodein.di.generic.instance

class MyViewModel(application: Application) : BaseViewModel(application) {

    private val repository: PlaceRepository by instance()

    var mylist: MutableLiveData<MutableList<WanAndroidBean.DataBean>> = MutableLiveData()

    var typeBoolean = true

    override fun initData() {

        getList(true)

    }

    fun getList(clear: Boolean) {
        launch {
            val result = businessHandler(repository.getProvinceListAsync())
            mylist.value = result
            if (clear) {
                refreshStatus.call()
            } else {
                loadMoreStatus.call()
            }
            typeBoolean = clear
        }
    }


}