package com.xiamuyao.ulanbator.util

import androidx.databinding.ObservableArrayList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.constant.EventConstant.PRICE_LIST
import com.xiamuyao.ulanbator.constant.EventConstant.RATE_DATA
import com.xiamuyao.ulanbator.constant.EventConstant.SELECT_CITY
import com.xiamuyao.ulanbator.constant.EventConstant.SELECT_CURRENCY
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.constant.ProjectConstant.USDTToExchangeRate
import com.xiamuyao.ulanbator.constant.ProjectConstant.inMemoryCurrency
import com.xiamuyao.ulanbator.model.bean.MarketBean
import com.xiamuyao.ulanbator.model.bean.response.RateBean
import com.xiamuyao.ulanbator.net.BaseResponse

object RateUtli {

    /**
     * 用户选择的计价货币
     * 资产综合
     * 汇率数据
     */
    fun getSumBy(
        value: String,
        value1: String,
        obtainExchangeRate: BaseResponse<RateBean.DataBean>
    ) {
//        selectPairByWeb(value, obtainExchangeRate)

    }

    /**
     * 根据用户选择的计价货币 计算汇率
     */
    fun selectPairByWeb(
        value: MarketBean.TickBean
    ): String {
        val tempName = value.pairName
        val tempPrice = value.close.toBigDecimal()
        var lastPrice = ""
        var pairToPrice = ""
        if (getUSDTToExchangeRate().isEmpty()) return ""
        lastPrice = tempPrice.multiply(getUSDTToExchangeRate().toBigDecimal()).stripTrailingZeros().toString()
//        getRateList().forEach {
//            if (it.rateName.startsWith("USDT") && it.rateName.endsWith(getSelectCurrency())) {
//                pairToPrice = it.rate
//                return@forEach
//            }
//        }
        return lastPrice

    }

    /**
     * 选择的国家
     */
    fun getSelectCity() {
        App.CONTEXT.getSpValue(SELECT_CITY, "中国")
    }

    /**
     * 保存国家
     */
    fun saveSelectCity() {
        App.CONTEXT.putSpValue(SELECT_CITY, "中国")
    }

    /**
     * 选择的计价货币
     */
    fun getSelectCurrency(): String {
        return if (inMemoryCurrency.isEmpty()) {
            val temp = App.CONTEXT.getSpValue(SELECT_CURRENCY, "CNY")
            inMemoryCurrency = temp
            inMemoryCurrency
        } else {
            inMemoryCurrency
        }
    }

    /**
     * 保存计价货币
     */
    fun SaveSelectCurrency(selectPair: String) {
        inMemoryCurrency = selectPair
        App.CONTEXT.putSpValue(SELECT_CURRENCY, selectPair)
    }

    /**
     * 获取行情数据
     */
    fun getPriceList(): ObservableArrayList<MarketBean.TickBean> {
        //如果内存为空
        return if (App.marketList.isEmpty()) {
            //如果本地为空
            val spValue = App.CONTEXT.getSpValue(PRICE_LIST, "")
            //构建默认数据
            return if (spValue.isEmpty()) {
                val defPriceList = getDefPriceList()
                SavePriceList(defPriceList)
                defPriceList
            } else {
                //返回本地序列化数据
                val fromJson = Gson().fromJson<List<MarketBean.TickBean>>(
                    spValue,
                    object : TypeToken<List<MarketBean.TickBean>>() {}.type
                )
                App.marketList.addAll(fromJson)
                App.marketList
            }
        } else {
            App.marketList
        }
    }

    /**
     * 保存行情数据
     */
    fun SavePriceList(marketList: ObservableArrayList<MarketBean.TickBean>) {
        val toJson = JSONUtils.toJson(marketList)
        App.CONTEXT.putSpValue(PRICE_LIST, toJson)
        App.marketList = marketList
    }

    /**
     * 获取汇率数据
     */
    fun getRateList(): MutableList<RateBean.DataBean.ListBean> {
        return if (App.fromCloudRate.isNullOrEmpty()) {
            val temp = App.CONTEXT.getSpValue(RATE_DATA, "")
            if (temp.isEmpty()) return ObservableArrayList()
            App.fromCloudRate.addAll(
                Gson().fromJson<List<RateBean.DataBean.ListBean>>(
                    temp,
                    object : TypeToken<List<RateBean.DataBean.ListBean>>() {}.type
                )
            )
            App.fromCloudRate
        } else {
            App.fromCloudRate
        }
    }

    /**
     * 保存汇率数据
     */
    fun saveRateList(obtainExchangeRate: MutableList<RateBean.DataBean.ListBean>) {

        for (it in obtainExchangeRate) {

            if (it.rateName.startsWith("USDT") && it.rateName.endsWith(getSelectCurrency())) {
                //更改计价货币的实时汇率
                saveUSDTToExchangeRate(it.rate)
                break
            }
        }

        val toJson = JSONUtils.toJson(obtainExchangeRate)
        //保存本地数据
        App.CONTEXT.putSpValue(EventConstant.RATE_DATA, toJson)
        //更改内存数据
        App.fromCloudRate = obtainExchangeRate
    }

    /**
     * 获取默认的行情数据
     */
    fun getDefPriceList(): ObservableArrayList<MarketBean.TickBean> {
        val btcusdt = MarketBean.TickBean()
        btcusdt.cch = "market.btcusdt.detail"
        btcusdt.pairName = "BTC"
        btcusdt.pairAndToName = "BTCUSDT"

        val ethusdt = MarketBean.TickBean()
        ethusdt.cch = "market.ethusdt.detail"
        ethusdt.pairName = "ETH"
        btcusdt.pairAndToName = "ETHUSDT"

        val ltcusdt = MarketBean.TickBean()
        ltcusdt.cch = "market.ltcusdt.detail"
        ltcusdt.pairName = "LTC"
        btcusdt.pairAndToName = "LTCUSDT"

        val eosusdt = MarketBean.TickBean()
        eosusdt.cch = "market.eosusdt.detail"
        eosusdt.pairName = "EOS"
        btcusdt.pairAndToName = "EOSUSDT"

        val etcusdt = MarketBean.TickBean()
        etcusdt.cch = "market.etcusdt.detail"
        etcusdt.pairName = "ETC"
        btcusdt.pairAndToName = "ETCUSDT"


        val observableArrayList = ObservableArrayList<MarketBean.TickBean>()

        observableArrayList.add(btcusdt)
        observableArrayList.add(ethusdt)
        observableArrayList.add(ltcusdt)
        observableArrayList.add(eosusdt)
        observableArrayList.add(etcusdt)

        return observableArrayList
    }

    /**
     * BTCtoUsdt
     */
    fun BtcToUsdt(): String {
        for (tickBean in getPriceList()) {
            if (tickBean.pairName == "BTC") {
                return tickBean.close
            }
        }
        return "0"
    }

    /**
     * 获取计价货币对应的汇率
     */
    fun getUSDTToExchangeRate(): String {
        return if (ProjectConstant.USDTToExchangeRate.isEmpty()) {
            val spValue = App.CONTEXT.getSpValue(EventConstant.USDTToExchangeRate, "0")
            ProjectConstant.USDTToExchangeRate = spValue
            ProjectConstant.USDTToExchangeRate
        } else {
            ProjectConstant.USDTToExchangeRate
        }
    }

    /**
     * 保存计价货币对应的汇率
     */
    fun saveUSDTToExchangeRate(value: String) {
        App.CONTEXT.putSpValue(USDTToExchangeRate, value)
        USDTToExchangeRate = value
    }


}