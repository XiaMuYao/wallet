package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.model.bean.MarketBean

class MainViewModel(application: Application) : BaseViewModel(application) {

    //底部点击菜单控件List
    var bottomClickIdList = arrayListOf(
        R.id.mainBottomTabOne,
        R.id.mainBottomTabTwo,
        R.id.mainBottomTabThere,
        R.id.mainBottomTabFour,
        R.id.mainBottomTabFive
    )

    //底部菜单ImageView控件List
    var bottomClickImageIdList = arrayListOf(
        R.id.bottom_tab_iv_one,
        R.id.bottom_tab_iv_two,
        R.id.bottom_tab_iv_there,
        R.id.bottom_tab_iv_four,
        R.id.bottom_tab_iv_five
    )

    var fragmentIndex = MutableLiveData<Int>()

    var marketList = ObservableArrayList<MarketBean.TickBean>()

    init {
        fragmentIndex.value = 0

        val btcusdt = MarketBean.TickBean()
        btcusdt.cch = "market.btcusdt.detail"
        btcusdt.pairName = "BTC"

        val ethusdt = MarketBean.TickBean()
        ethusdt.cch = "market.ethusdt.detail"
        ethusdt.pairName = "ETH"

        val ltcusdt = MarketBean.TickBean()
        ltcusdt.cch = "market.ltcusdt.detail"
        ltcusdt.pairName = "LTC"

        val eosusdt = MarketBean.TickBean()
        eosusdt.cch = "market.eosusdt.detail"
        eosusdt.pairName = "EOS"

        val etcusdt = MarketBean.TickBean()
        etcusdt.cch = "market.etcusdt.detail"
        etcusdt.pairName = "ETC"

        marketList.add(btcusdt)
        marketList.add(ethusdt)
        marketList.add(ltcusdt)
        marketList.add(eosusdt)
        marketList.add(etcusdt)
    }

    override fun initData() {

    }

    /**
     * 更改ViewPager下标
     * @param index Int
     */
    fun setViewPagerIndex(index: Int) {
        fragmentIndex.value = index
    }


}