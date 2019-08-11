package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.utlis.DataBus
import com.zhangke.websocket.WebSocketHandler

class QuotationViewModel(application: Application) : BaseViewModel(application) {

    override fun initData() {
//        val className = javaClass.name
//        LL.WanAndroidBean("$className 加载了数据")

        launch {
            DataBus.postData(EventConstant.quote_Refresh, "")
            kotlinx.coroutines.delay(2000)
            App.marketList = RateUtli.getPriceList()

            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_BTC)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_ETH)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_LTC)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_EOS)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_ETC)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_DASH)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_BCH)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_XRP)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_TRX)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_DOGE)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_MFTKRWT)
        }
    }

}