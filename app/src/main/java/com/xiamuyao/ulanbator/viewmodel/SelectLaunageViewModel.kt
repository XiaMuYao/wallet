package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LanguageUtils
import com.xiamuyao.ulanbator.activity.LaunchActivity
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.activity.SystemSettingActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.util.CityUtli
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.utlis.*

class SelectLaunageViewModel(application: Application) : BaseViewModel(application) {

    var slectIndex = MutableLiveData<Int>()
    var finshThisActivity = SingleLiveEvent<Boolean>()
    var seleValue = 0
    override fun initData() {
        for ((index, data) in CityUtli.cityList.withIndex()) {

            if (data.cityId == CityUtli.getLanguage()) {
                slectIndex.value = data.cityId
                break
            }

        }
    }


    /**
     * 保存语言
     */
    fun saveTheCurrency(value: Int) {
        seleValue =value
        finshThisActivity.call()
//        ActivityStackManager.getInstance().finishAllActivity()
//        startActivity(LaunchActivity::class.java)
//        LanguageUtils.applyLanguage(CityUtli.geyLanguageBySys(find.cityId)!!, "com.xiamuyao.ulanbator.activity.LaunchActivity")
    }

}