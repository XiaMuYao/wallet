package com.xiamuyao.ulanbator.model.repository

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.model.bean.FindMessageBean
import com.xiamuyao.ulanbator.network.api.FindService
import com.xiamuyao.ulanbator.util.toTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FindRepository(private var findService: FindService) {

    /**
     * 获取发现页信息
     */
    suspend fun getDiscoveryPageInformation(value: String) = withContext(Dispatchers.IO) {
        var temp = 0
        when (value) {
            App.CONTEXT.getString(R.string.gonggao) -> {
                temp = 1
            }
            App.CONTEXT.getString(R.string.zixun) -> {
                temp = 2
            }
            App.CONTEXT.getString(R.string.bangzhuzhongxin) -> {
                temp = 3
            }
            "DAPP" -> {
                temp = 4
            }
        }
        val discoveryPageInformation = findService.getDiscoveryPageInformation(temp.toString())
        val tempList = ObservableArrayList<FindMessageBean>()

        if (discoveryPageInformation.result.returnCode == "0") {
            discoveryPageInformation.data.list.forEach {
                val findMessageBean = FindMessageBean()
                findMessageBean.id = it.infoId
                findMessageBean.messageTime = "${it.author} ${it.createTime.toTime()}"
                findMessageBean.messageSubTitle = it.intro
                findMessageBean.messageTitle = it.title
                findMessageBean.url = it.url
                tempList.add(findMessageBean)
            }
        }

        return@withContext tempList
    }

    /**
     * 读取信息
     */
    suspend fun readInformation(value: String) = withContext(Dispatchers.IO) {
        return@withContext findService.readInformation(value)
    }


    companion object {

        private var instance: FindRepository? = null

        fun getInstance(findService: FindService): FindRepository {
            if (instance == null) {
                synchronized(FindRepository::class.java) {
                    if (instance == null) {
                        instance = FindRepository(findService)
                    }
                }
            }
            return instance!!
        }
    }
}