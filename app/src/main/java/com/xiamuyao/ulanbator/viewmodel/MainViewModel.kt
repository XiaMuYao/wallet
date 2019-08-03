package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.RATE_DATA
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.MarketBean
import com.xiamuyao.ulanbator.model.bean.response.RateBean
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.util.getSpValue
import org.kodein.di.generic.instance

class MainViewModel(application: Application) : BaseViewModel(application) {
    private val repository: WalletRepository by instance()

    var loadOk = MutableLiveData<Boolean>()

    //底部点击菜单控件List
    var bottomClickIdList = arrayListOf(
        R.id.mainBottomTabOne,
        R.id.mainBottomTabTwo,
        R.id.mainBottomTabThere,
        R.id.mainBottomTabFour,
        R.id.mainBottomTabFive
    )

    //底部菜单ImageView控件List
    var bottomClickImageIdList = arrayListOf(
        R.id.bottom_tab_iv_one,
        R.id.bottom_tab_iv_two,
        R.id.bottom_tab_iv_there,
        R.id.bottom_tab_iv_four,
        R.id.bottom_tab_iv_five
    )

    var fragmentIndex = MutableLiveData<Int>()


    init {
        fragmentIndex.value = 0
        loadOk.value = true
    }

    override fun initData() {
        //汇率数据默认第一次调用
        getExchangeRateData()
    }


    /**
     * 获取汇率数据
     */
    @Synchronized
    fun getExchangeRateData() {
        loadOk.value = false
        launch {
            repository.obtainExchangeRate()
            loadOk.value = true
        }
    }

    /**
     * 更改ViewPager下标
     * @param index Int
     */
    fun setViewPagerIndex(index: Int) {
        fragmentIndex.value = index
    }

}