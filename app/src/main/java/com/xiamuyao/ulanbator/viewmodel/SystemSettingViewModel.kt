package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.CityUtli
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency

class SystemSettingViewModel(application: Application) : BaseViewModel(application) {

    var selectPair = MutableLiveData<String>()
    var selectCity = MutableLiveData<String>()

    override fun initData() {

        selectPair.value = getSelectCurrency()
        val language = CityUtli.getLanguage()
        val find = CityUtli.cityList.find { it.cityId == language }

        selectCity.value = find?.cityName
    }

}