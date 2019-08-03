package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.bean.response.GetMoneyShopBean
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import org.kodein.di.generic.instance

/**
 * 合约 ViewModel
 */
class ContractFragmentViewModel(application: Application) : BaseViewModel(application) {

    var contractList = ObservableArrayList<GetMoneyShopBean.DataBean.ListBean>()

    private val repository: MoneyRepository by instance()


    override fun initData() {

        getContractList()
    }

    private fun getContractList() {
        launch {
            val accessToWealthManagementProducts = repository.accessToWealthManagementProducts(1.toString())
            businessHandler(accessToWealthManagementProducts) {
                contractList.addAll(accessToWealthManagementProducts.data.list)
            }

        }
    }

}