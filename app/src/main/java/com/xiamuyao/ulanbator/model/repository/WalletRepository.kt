package com.xiamuyao.ulanbator.model.repository

import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.bean.response.WalletHomeLocalOptationBean
import com.xiamuyao.ulanbator.net.BaseResponse
import com.xiamuyao.ulanbator.network.api.WalletService
import com.xiamuyao.ulanbator.util.JSONUtils
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency
import com.xiamuyao.ulanbator.util.putSpValue
import com.xiamuyao.ulanbator.utlis.LL
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
            data.list.forEach {
                observableArrayList.add(
                    WalletListBean(
                        it.symbolName.toUpperCase(),
                        it.amount.replace(",",""),
                        it.symbolType.toString(), "", "",
                        it.symbolName.toUpperCase() + "USDT","","",getSelectCurrency()
                    )
                )
            }
        }

        val walletHomeLocalOptationBean = WalletHomeLocalOptationBean()
        val dataBean = WalletHomeLocalOptationBean.DataBean()
        //装载List
        dataBean.list = observableArrayList
        //总资产折合
        if (dataBean.list.isNotEmpty()) {
            dataBean.userSumMoney =
                dataBean.list.sumByDouble {
                    it.pariAmount.replace(",", "").toBigDecimal().stripTrailingZeros().toDouble()
                }.toString()
        }
        //总资产折合-估值
        walletHomeLocalOptationBean.data = dataBean
        BaseResponse(theWalletAssetHomepage.result, walletHomeLocalOptationBean)
    }

    /**
     * 获取汇率
     */
    suspend fun obtainExchangeRate() = withContext(Dispatchers.IO) {
        val obtainExchangeRate = walletService.obtainExchangeRate()
        if (obtainExchangeRate.result.returnCode == "0") {
            val toJson = JSONUtils.toJson(obtainExchangeRate.data.list)
            LL.d("汇率Json:$toJson")
            //保存内存和缓存的数据
            RateUtli.saveRateList(obtainExchangeRate.data.list)
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
