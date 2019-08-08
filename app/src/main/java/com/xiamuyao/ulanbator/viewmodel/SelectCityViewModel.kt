package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.response.CityListBean
import com.xiamuyao.ulanbator.model.repository.UserRepository
import org.kodein.di.generic.instance

class SelectCityViewModel(application: Application) : BaseViewModel(application) {

    var cityList = ObservableArrayList<CityListBean.DataBean.ListBean>()
    var cityListCopy = ObservableArrayList<CityListBean.DataBean.ListBean>()

    private val userRepository: UserRepository by instance()

    var text = MutableLiveData<String>()
    override fun initData() {
        getCityList()
    }

    private fun getCityList() {

        launch {
            cityList.addAll(userRepository.getCityList())
            cityListCopy.addAll(cityList)
        }
    }

    fun finsh() {
        finishStatus.call()
    }

}