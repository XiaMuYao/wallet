package com.xiamuyao.ulanbator

import android.annotation.SuppressLint
import android.content.Context
import com.jeremyliao.liveeventbus.LiveEventBus

@SuppressLint("StaticFieldLeak")
object LibApp {
    private var context: Context? = null


    fun init(c: Context) {

        context = c

        setLiveDataBus()
    }

    fun setLiveDataBus() {

        LiveEventBus.get()
            .config()
            .supportBroadcast(context)
            .lifecycleObserverAlwaysActive(true)

    }


    fun getContext(): Context {
        return context!!
    }

}