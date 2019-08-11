package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.jeremyliao.liveeventbus.utils.AppUtils.getApplicationContext
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.TOKEN
import com.xiamuyao.ulanbator.model.bean.HomeListBean
import com.xiamuyao.ulanbator.model.bean.WalletListBean
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.*
import com.xiamuyao.ulanbator.util.ArithUtil.convertNumber3
import com.xiamuyao.ulanbator.util.RateUtli.getPriceList
import com.xiamuyao.ulanbator.util.RateUtli.getRateList
import com.xiamuyao.ulanbator.util.RateUtli.getSelectCurrency
import com.xiamuyao.ulanbator.util.RateUtli.getUSDTToExchangeRate
import com.xiamuyao.ulanbator.utlis.LL
import kotlinx.android.synthetic.main.activity_transferaccounts.*
import org.kodein.di.generic.instance

class WalletViewModel(application: Application) : BaseViewModel(application) {

    private val repository: WalletRepository by instance()

    val walletList = ObservableArrayList<WalletListBean>()

    var showOrHide = MutableLiveData<Boolean>()

    var priceSum = MutableLiveData<String>()
    var priceToPair = MutableLiveData<String>()
    var priceToName = MutableLiveData<String>()
    var priceName = MutableLiveData<String>()
    var inviteCode = MutableLiveData<String>()

    var calculationStatus = MutableLiveData<Boolean>()

    //生活
    var lifeObservableArrayList = ObservableArrayList<HomeListBean>()

    //游戏
    var gameObservableArrayList = ObservableArrayList<HomeListBean>()

    init {
        showOrHide.value = true
        priceSum.value = "0"
        priceToPair.value = "0"
        priceToName.value = RateUtli.getSelectCurrency()
        //固定BTC
        priceName.value = "BTC"
        //用户ID
        inviteCode.value = "ID:999999"
        calculationStatus.value = true
    }

    override fun initData() {
        //获取资产总值
        getTheTotalValueOfTheAsset()

    }

    /**
     * 刷新货币
     */
    fun refreshCurrency() {

        priceToName.value = RateUtli.getSelectCurrency()
        initData()
    }

    /**
     * 获取资产总值
     */
    fun getTheTotalValueOfTheAsset() {
        launch {
            val theWalletAssetHomepage = repository.getTheWalletAssetHomepage()
            businessHandler(theWalletAssetHomepage) {
                theWalletAssetHomepage.data.let {
                    walletList.clear()
                    walletList.addAll(it.data.list)
                    //币种个数 一起转换USDT = BTC shuliang
                    inviteCode.value = UsetUtli.getUserId()
                    calculationStatus.value = false
                    setTheSumOfAssets()
                    calculationStatus.value = true
                }
            }
        }
    }


    fun showOrHideListData() {
        walletList.forEach {
            it.showHide = showOrHide.value!!
        }
    }

    /**
     * 刷新资产总和
     */
    fun setTheSumOfAssets() {
        LL.d("刷新资产总和")
        var tempSum = "0"
        var tempMoney = "0"

        for (that in walletList) {

            if (that.pariAmount == "0" || that.pariAmount.isEmpty()) {
                that.pariToPrice = "0"
            }

            //平台币使用汇率接口
            if (that.pairToName == TOKEN + "USDT") {
                //在行情数据中 找到 平台币 —> 韩元
                for (it in getPriceList()) {
                    //平台币 —> 韩元
                    if (it.pairAndToName == TOKEN + "USDT") {


//                        //平台币 -> 韩元
                        var mul = ""
//
//                        //韩元 -> USDT
//                        val find = getRateList().find { it.rateName == "USDTKRW" }
//                        that.pairToUSDT =
//                            BigDecimalUtils.div(mul.replace(",", ""), find?.rate?.replace(",", "")!!)
//
//                        //USDT 转换 BTC
//                        that.PairToBTC = USDTtoBtc(that.pairToUSDT)


                        val find = getPriceList().find { it.pairAndToName == "MFTUSDT" }
//                        //USDT 转计价货币
                        if (getSelectCurrency() == "KRW") {
                            that.pariToPrice =BigDecimalUtils.mul(it.toKRW, that.pariAmount.replace(",", ""))
                        } else {
                            val convertNumber3 = ArithUtil.convertNumber3(find?.pairToPrice!!, 4)
                            that.pariToPrice = BigDecimalUtils.mul(convertNumber3, that.pariAmount.replace(",", ""))
                        }
//
//                        //当前货币对toUSDT的价格
                        that.PairToUSDTPrice = it.close

                        break
                    }
                }

            } else {

                //公链币种
                for (it in RateUtli.getPriceList()) {

                    if (that.pairToName == it.pairAndToName) {
                        //当前货币 转 USDT
                        that.pairToUSDT =
                            BigDecimalUtils.mul(that.pariAmount.replace(",", ""), it.close)

                        //USDT 转 BTC
                        that.PairToBTC = USDTtoBtc(that.pairToUSDT)

                        //USDT 转计价货币
                        that.pariToPrice = USDTtoChangeRate(that.pairToUSDT)

                        //当前货币对toUSDT的价格
                        that.PairToUSDTPrice = it.close
                        break
                    }

                }
            }


            //保存当前汇率数据
            saveCurrentExchangeRateData(that)
            //计算比特总和
            if (that.PairToBTC.isEmpty()) {
                tempSum += 0
            } else {
                tempSum = BigDecimalUtils.add(tempSum, that.PairToBTC)
            }
            //计算计价货币综合价值
            if (that.pariToPrice.isNullOrEmpty()) {
                tempMoney += 0
            } else {
                tempMoney =
                    BigDecimalUtils.add(tempMoney, that.pariToPrice!!)

            }
            that.pariToPrice = convertNumber3(that.pariToPrice.toString())

        }

        LL.d("计算比特总和::$tempSum")
        LL.d("计算计价货币总和::$tempMoney")
        priceSum.value = tempSum.toBigDecimal().stripTrailingZeros().toPlainString()
        priceToPair.value =
            ArithUtil.convertNumber3(tempMoney.toBigDecimal().stripTrailingZeros().toPlainString())
    }

    /**
     * USDT 转 BTC
     */
    private fun USDTtoBtc(pairToUSDT: String): String {
        val toPlainString = BigDecimalUtils.div(pairToUSDT, RateUtli.BtcToUsdt())
        if (toPlainString.isEmpty()) return "0"
        return toPlainString
    }

    /**
     * USDT 转计价货币
     */
    private fun USDTtoChangeRate(pairToUSDT: String): String {
        val stripTrailingZeros = BigDecimalUtils.mul(pairToUSDT, getUSDTToExchangeRate())
        if (stripTrailingZeros.isEmpty()) return "0"
        return stripTrailingZeros
    }

    /**
     * 保存当前汇率数据
     */
    private fun saveCurrentExchangeRateData(that: WalletListBean) {

    }


    fun gameList() {
        gameObservableArrayList.add(HomeListBean("1", R.drawable.icon_07, getApplicationContext().getString(R.string.caipiao)))
        gameObservableArrayList.add(HomeListBean("1", R.drawable.icon_10, getApplicationContext().getString(R.string.dazhuanpan)))
        gameObservableArrayList.add(HomeListBean("1", R.drawable.icon_09, getApplicationContext().getString(R.string.jincgaui)))
        gameObservableArrayList.add(HomeListBean("1", R.drawable.icon_08, context.getString(R.string.zuqiu)))
        gameObservableArrayList.add(HomeListBean("1", R.drawable.icon_11, context.getString(R.string.baijiale)))
        gameObservableArrayList.add(HomeListBean("1", R.drawable.icon_12, context.getString(R.string.dezhou)))
    }

    fun lifeList() {
        lifeObservableArrayList.add(HomeListBean("1", R.drawable.icon_01, context.getString(R.string.jiudian)))
        lifeObservableArrayList.add(HomeListBean("1", R.drawable.icon_02, context.getString(R.string.jipiao)))
        lifeObservableArrayList.add(HomeListBean("1", R.drawable.icon_03, context.getString(R.string.shoujichongzhi)))
        lifeObservableArrayList.add(HomeListBean("1", R.drawable.icon_04, context.getString(R.string.dazhejuan)))
        lifeObservableArrayList.add(HomeListBean("1", R.drawable.icon_05, context.getString(R.string.jiaofei)))
        lifeObservableArrayList.add(HomeListBean("1", R.drawable.icon_06, context.getString(R.string.yiliao)))
    }
}