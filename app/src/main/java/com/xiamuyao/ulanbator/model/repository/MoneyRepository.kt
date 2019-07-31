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
            var sum = with(data) {
                val a = data.ethUSD.toBigDecimal().plus(
                    usdtUSD.toBigDecimal().plus(
                        eosUSD.toBigDecimal().plus(
                            ltcUSD.toBigDecimal().plus(
                                ethUSD.toBigDecimal().plus(
                                    tokenUSD.toBigDecimal().plus(
                                        btcUSD.toBigDecimal()
                                    )
                                )
                            )

                        )
                    )
                )
                return@with a.toString()
            }
            provinces.data.sum = sum
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
    suspend fun buyingWealthManagementProducts() = withContext(Dispatchers.IO) {
        val provinces = moneyService.buyingWealthManagementProducts()
        return@withContext provinces
    }

    /**
     * 解除合约
     */
    suspend fun transfer() = withContext(Dispatchers.IO) {
        val provinces = moneyService.transfer()
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