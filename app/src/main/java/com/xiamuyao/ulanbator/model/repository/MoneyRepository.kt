package com.xiamuyao.ulanbator.model.repository

import com.xiamuyao.ulanbator.network.api.MoneyService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoneyRepository(private var moneyService: MoneyService) {

    /**
     * 理财首页信息
     */
    suspend fun financialHomeInformation() = withContext(Dispatchers.IO) {
        val provinces = moneyService.financialHomeInformation()
        val data = provinces.data
        if (provinces.result.returnCode == "0") {
            data.sum =
                data.listSymbolUsd.sumByDouble {
                    it.amount.replace(",", "").toBigDecimal().toDouble()
                }.toString()
        }
        return@withContext provinces
    }

    /**
     * 获取理财账户详情
     */
    suspend fun getFinancialAccountDetails() = withContext(Dispatchers.IO) {
        val provinces = moneyService.getFinancialAccountDetails()
        return@withContext provinces
    }

    /**
     * 获取理财产品
     */
    suspend fun accessToWealthManagementProducts(productType: String) = withContext(Dispatchers.IO) {
        val provinces = moneyService.accessToWealthManagementProducts(productType)
        return@withContext provinces
    }

    /**
     * 购买理财产品
     */
    suspend fun buyingWealthManagementProducts(productId: String, amount: String, symbolType: String) =
        withContext(Dispatchers.IO) {
            val provinces = moneyService.buyingWealthManagementProducts(productId, amount, symbolType)
            return@withContext provinces
        }

    /**
     * 解除合约
     */
    suspend fun transfer(value: String) = withContext(Dispatchers.IO) {
        val provinces = moneyService.transfer(value)
        return@withContext provinces
    }

    /**
     * 获取理财详情
     */
    suspend fun getFinancialManagementDetails(productId: String) = withContext(Dispatchers.IO) {
        val provinces = moneyService.getFinancialManagementDetails(productId)
        return@withContext provinces
    }

    companion object {

        private var instance: MoneyRepository? = null

        fun getInstance(moneyService: MoneyService): MoneyRepository {
            if (instance == null) {
                synchronized(MoneyRepository::class.java) {
                    if (instance == null) {
                        instance = MoneyRepository(moneyService)
                    }
                }
            }
            return instance!!
        }
    }
}