package com.xiamuyao.sample.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.xiamuyao.sample.model.bean.WanAndroidBean
import com.xiamuyao.sample.network.api.BusinessService
import com.xiamuyao.ulanbator.net.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlaceRepository(private var placeService: BusinessService) {

    suspend fun getProvinceList() = withContext(Dispatchers.IO) {
        return@withContext placeService.getProvinces()
    }

    fun testLiveData(): LiveData<Resource<WanAndroidBean>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))

            emit(Resource.success(placeService.getProvinces()))
        }
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