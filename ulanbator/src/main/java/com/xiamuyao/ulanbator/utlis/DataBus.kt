package com.xiamuyao.ulanbator.utlis

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2019/5/23
 * 描    述：
 * 修订历史：
 * ================================================
 */

object DataBus {

    fun postData(key: String, data: Any) {
        LiveEventBus.get().with(key, Any::class.java).post(data)
    }


    fun <T> observeData(contextLifecycle: LifecycleOwner, key: String, observer: DataBusObservable<T>) {

        LiveEventBus.get().with(key, Any::class.java).observe(contextLifecycle, Observer {
            observer.DataBusDataCallBack(it as T)
        })


    }

}

interface DataBusObservable<T> {
    fun DataBusDataCallBack(it: T)
}

