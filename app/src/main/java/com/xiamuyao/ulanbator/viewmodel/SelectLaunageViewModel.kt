package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LanguageUtils
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.activity.SystemSettingActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.util.CityUtli
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.LL

class SelectLaunageViewModel(application: Application) : BaseViewModel(application) {

    var slectIndex = MutableLiveData<Int>()

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
        val find = CityUtli.cityList.find { it.cityId == value }
        CityUtli.saveLanguage(find?.cityId!!)
        finishStatus.call()
        ActivityStackManager.getInstance().finishAllActivity()
        LanguageUtils.applyLanguage(CityUtli.geyLanguageBySys(find.cityId)!!, MainActivity::class.java)
    }

}