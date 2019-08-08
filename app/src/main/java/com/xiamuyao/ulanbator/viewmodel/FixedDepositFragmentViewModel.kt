package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.response.GetMoneyShopBean
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.util.businessHandler
import org.kodein.di.generic.instance

/**
 * 定存 ViewModel
 */
class FixedDepositFragmentViewModel(application: Application) : BaseViewModel(application) {

    var fixedList = ObservableArrayList<GetMoneyShopBean.DataBean.ListBean>()

    private val repository: MoneyRepository by instance()

    override fun initData() {

        getFixedList()
    }

     fun getFixedList() {

        launch {
            val accessToWealthManagementProducts = repository.accessToWealthManagementProducts(2.toString())
            businessHandler(accessToWealthManagementProducts) {
                fixedList.clear()
                fixedList.addAll(accessToWealthManagementProducts.data.list)
            }

        }

    }

}