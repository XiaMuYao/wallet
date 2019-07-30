package com.xiamuyao.ulanbator.model.repository

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.bean.response.WalletHomeLocalOptationBean
import com.xiamuyao.ulanbator.net.BaseResponse
import com.xiamuyao.ulanbator.network.api.WalletService
import com.xiamuyao.ulanbator.util.putSpValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WalletRepository(private var walletService: WalletService) {

    /**
     * 获取资产综合列表
     */
    suspend fun getTheWalletAssetHomepage(niu: String = "") = withContext(Dispatchers.IO) {
        val theWalletAssetHomepage = walletService.getTheWalletAssetHomepage(niu)
        val observableArrayList = ObservableArrayList<WalletListBean>()
        val data = theWalletAssetHomepage.data

        if (theWalletAssetHomepage.result.returnCode == "0") {
            //货币余额处理
            observableArrayList.add(WalletListBean("BTC", "", "", data.btc, ""))
            observableArrayList.add(WalletListBean("ETC", "", "", data.etc, ""))
            observableArrayList.add(WalletListBean("ETH", "", "", data.eth, ""))
            observableArrayList.add(WalletListBean("EOS", "", "", data.eos, ""))
            observableArrayList.add(WalletListBean("USDT", "", "", data.usdt, ""))
            observableArrayList.add(WalletListBean("LTC", "", "", data.ltc, ""))
            observableArrayList.add(WalletListBean("TOKEN", "", "", data.token, ""))
            //用户信息保存
            App.CONTEXT.putSpValue("nickname", data.nickname)
            App.CONTEXT.putSpValue("inviteCode", data.inviteCode)
            App.CONTEXT.putSpValue("vipType", data.vipType)
        }

        val walletHomeLocalOptationBean = WalletHomeLocalOptationBean()
        val dataBean = WalletHomeLocalOptationBean.DataBean()
        //装载List
        dataBean.list = observableArrayList
        //总资产折合
        dataBean.userSumMoney = dataBean.list.sumByDouble { it.pariPrice.replace(",", "").toDouble() }.toString()
        //总资产折合-估值

        walletHomeLocalOptationBean.data = dataBean
        BaseResponse(theWalletAssetHomepage.result, walletHomeLocalOptationBean)
    }

    /**
     * 获取汇率
     */
    suspend fun obtainExchangeRate() = withContext(Dispatchers.IO) {
        val obtainExchangeRate = walletService.obtainExchangeRate()
        val data = obtainExchangeRate.data
        App.marketList.forEach {
            it.pairAndToName
        }
        obtainExchangeRate
    }

    companion object {

        private var instance: WalletRepository? = null

        fun getInstance(walletService: WalletService): WalletRepository {
            if (instance == null) {
                synchronized(WalletRepository::class.java) {
                    if (instance == null) {
                        instance = WalletRepository(walletService)
                    }
                }
            }
            return instance!!
        }
    }
}
