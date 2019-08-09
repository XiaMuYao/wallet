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
import java.util.*

object RateUtli {


    /**
     * 法币兑换USDT
     */
    fun getUSDT(value: String): String {
        var tempvalue = value
        val find = getRateList().find { it.rateName == "USDTKRW" }
        if (find == null) return "1"
        val div = BigDecimalUtils.div(tempvalue, find?.rate!!)
        tempvalue = div
        return tempvalue
    }

    /**
     * 根据用户选择的计价货币 计算汇率
     */
    fun selectPairByWeb(
        value: MarketBean.TickBean
    ): String {
        //获取当前货币价格
        val tempPrice = value.close

        var lastPrice = ""
//        if (pingtai) {
//
////            //平台币 转换 法币(韩元)
////            val find = getDefPriceList().find { it.pairName == "MFT" }
////            //韩币价格
////            val mul = BigDecimalUtils.mul(find?.close!!, tempPrice)
////            //韩币 -> USDT
////            if (getUSDTToExchangeRate().isEmpty()) return ""
////            //当前计价货币 =  上一步 USDT
////            lastPrice = BigDecimalUtils.mul(mul, getUSDTToExchangeRate())
//
//            //BTC to USDT
//            if (getUSDTToExchangeRate().isEmpty()) return ""
//
//            //当前货币价格 * 当前货币 * USDT
//            lastPrice = BigDecimalUtils.mul(tempPrice, getUSDTToExchangeRate())
//
//            return lastPrice
//        } else {
        //BTC to USDT
        if (getUSDTToExchangeRate().isEmpty()) return ""

        //当前货币价格 * 当前货币 * USDT
        lastPrice = BigDecimalUtils.mul(tempPrice, getUSDTToExchangeRate())

        return lastPrice
//        }

    }

    /**
     * 选择的国家
     */
    fun getSelectCity(): String {
        if (App.CONTEXT.getSpValue(SELECT_CITY, "").isEmpty()) {
            val language = Locale.getDefault().getLanguage()
            val find = CityUtli.cityList.find { it.cityType == language }
            find?.cityName
        }
        return App.CONTEXT.getSpValue(SELECT_CITY, "中国")
    }

    /**
     * 选择的国家 区号
     */
    fun getSelectCityNum(): String {
        val selectCity = getSelectCity()

        return selectCity
    }


    /**
     * 选择的国家 国家代号
     */
    fun getSelectCityNumPlus(): String {
        return getSelectCity()
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
            val temp = App.CONTEXT.getSpValue(SELECT_CURRENCY, "USD")
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
        btcusdt.cch = "market_btcusdt_ticker"
        btcusdt.pairName = "BTC"
        btcusdt.pairAndToName = "BTCUSDT"

        val ethusdt = MarketBean.TickBean()
        ethusdt.cch = "market_ethusdt_ticker"
        ethusdt.pairName = "ETH"
        btcusdt.pairAndToName = "ETHUSDT"

        val ltcusdt = MarketBean.TickBean()
        ltcusdt.cch = "market_ltcusdt_ticker"
        ltcusdt.pairName = "LTC"
        ltcusdt.pairAndToName = "LTCUSDT"

        val eosusdt = MarketBean.TickBean()
        eosusdt.cch = "market_eosusdt_ticker"
        eosusdt.pairName = "EOS"
        eosusdt.pairAndToName = "EOSUSDT"

        val etcusdt = MarketBean.TickBean()
        etcusdt.cch = "market_etcusdt_ticker"
        etcusdt.pairName = "ETC"
        etcusdt.pairAndToName = "ETCUSDT"

        val dashusdt = MarketBean.TickBean()
        dashusdt.cch = "market_dashusdt_ticker"
        dashusdt.pairName = "DASH"
        dashusdt.pairAndToName = "DASHUSDT"

        val bchusdt = MarketBean.TickBean()
        bchusdt.cch = "market_bchusdt_ticker"
        bchusdt.pairName = "BCH"
        bchusdt.pairAndToName = "BCHUSDT"

        val xrpusdt = MarketBean.TickBean()
        xrpusdt.cch = "market_xrpusdt_ticker"
        xrpusdt.pairName = "XRP"
        xrpusdt.pairAndToName = "XRPUSDT"

        val trxusdt = MarketBean.TickBean()
        trxusdt.cch = "market_trxusdt_ticker"
        trxusdt.pairName = "TRX"
        trxusdt.pairAndToName = "TRXUSDT"

        val dogeusdt = MarketBean.TickBean()
        dogeusdt.cch = "market_dogeusdt_ticker"
        dogeusdt.pairName = "DOGE"
        dogeusdt.pairAndToName = "DOGEUSDT"

        val mftkrwt = MarketBean.TickBean()
        mftkrwt.cch = "market_mftkrwt_ticker"
        mftkrwt.pairName = "MFT"
        mftkrwt.pairAndToName = "MFTKRWT"
        mftkrwt.close = "1"

        val observableArrayList = ObservableArrayList<MarketBean.TickBean>()

        observableArrayList.add(mftkrwt)
        observableArrayList.add(btcusdt)
        observableArrayList.add(ethusdt)
        observableArrayList.add(ltcusdt)
        observableArrayList.add(eosusdt)
        observableArrayList.add(etcusdt)

        observableArrayList.add(dashusdt)
        observableArrayList.add(bchusdt)
        observableArrayList.add(xrpusdt)
        observableArrayList.add(trxusdt)
        observableArrayList.add(dogeusdt)

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

//        val selectCurrency = getSelectCurrency()
//        if (selectCurrency == "KRW") {
//            val find = getPriceList().find { it.pairAndToName == "MFTUSDT" }
//            val usdt = getUSDT(find?.close!!)
//            val mul = BigDecimalUtils.div("1", usdt)
//            return mul
//        }

        return if (USDTToExchangeRate.isEmpty()) {
            val spValue = App.CONTEXT.getSpValue(EventConstant.USDTToExchangeRate, "0")
            USDTToExchangeRate = spValue
            USDTToExchangeRate
        } else {
            USDTToExchangeRate
        }
    }

    /**
     * 保存计价货币对应的汇率
     */
    fun saveUSDTToExchangeRate(value: String) {
        App.CONTEXT.putSpValue(USDTToExchangeRate, value)
        USDTToExchangeRate = value
    }

    /**
     * 获取当前货币对符号
     */
    fun getPairN(): String {

        val tempPrirName = getSelectCurrency()
        when {
            tempPrirName.contains("CNY") -> {
                return "¥"
            }
            tempPrirName.contains("USD") -> {
                return "$"

            }
            tempPrirName.contains("JPY") -> {
                return "￥"

            }
            tempPrirName.contains("KRW") -> {
                return "₩"

            }
            else -> {
                return ""
            }
        }
    }


}