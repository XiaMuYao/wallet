package com.xiamuyao.ulanbator.model.repository

import com.xiamuyao.ulanbator.network.api.MoneyService

class MoneyRepository(private var moneyService: MoneyService) {

//    suspend fun getProvinceListAsync() = withContext(Dispatchers.IO) {
//        val provinces = moneyService.accessToWealthManagementProducts()
//
//        return@withContext placeService.getProvinces()
//    }

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