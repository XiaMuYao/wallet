package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.CityListBean

class SelectCityViewModel(application: Application) : BaseViewModel(application) {

    var cityList = ObservableArrayList<CityListBean>()


    override fun initData() {
        getCityList()
    }

    private fun getCityList() {
        for (i in 0..30) {
            val cityListBean = CityListBean()
            cityListBean.cityNum = "+$i 86"
            cityList.add(cityListBean)
        }

    }

}