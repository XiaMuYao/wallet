package com.xiamuyao.sample.model.repository

import com.xiamuyao.sample.network.api.BusinessService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlaceRepository(private var placeService: BusinessService) {

    suspend fun getProvinceListAsync() = withContext(Dispatchers.IO) {
        return@withContext placeService.getProvinces()
    }

    companion object {

        private var instance: PlaceRepository? = null

        fun getInstance(placeService: BusinessService): PlaceRepository {
            if (instance == null) {
                synchronized(PlaceRepository::class.java) {
                    if (instance == null) {
                        instance = PlaceRepository(placeService)
                    }
                }
            }
            return instance!!
        }
    }
}