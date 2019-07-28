package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.CityListBean
import com.xiamuyao.ulanbator.model.repository.UserRepository
import org.kodein.di.generic.instance

class SelectCityViewModel(application: Application) : BaseViewModel(application) {

    var cityList = ObservableArrayList<CityListBean>()

    private val userRepository: UserRepository by instance()

    override fun initData() {
        getCityList()
    }

    private fun getCityList() {

        launch {
            for (i in 0..userRepository.getCityList().size) {
                val cityListBean = CityListBean()
            cityList.add(cityListBean)
            }
        }
//        for (i in 0..30) {
//            val cityListBean = CityListBean()
//            cityListBean.cityNum = "+$i 86"
//            cityList.add(cityListBean)
//        }

    }

}