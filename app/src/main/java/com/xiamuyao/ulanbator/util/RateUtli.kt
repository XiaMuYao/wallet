package com.xiamuyao.ulanbator.util

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
     * 用户选择的计价货币
     * 汇率数据
     */
    fun selectPairByWeb(
        value: String
    ) {
        when (value) {
            "BTCKRW" -> {
            }
            "BTCJPY" -> {
            }
            "BTCCNY" -> {
            }
            "BTCUSD" -> {
            }
            "USDJPY" -> {
            }
            "USDTUSD" -> {
            }
            "USDCNY" -> {
            }
            "USDKRW" -> {
            }
            "USDTCNY" -> {
            }
            "USDTKRW" -> {
            }
            "USDTJPY" -> {
            }


            "BTCUSTD"->{ }
            "ETHUSTD"->{ }
            "LTCUSTD"->{ }
            "EOSUSTD"->{ }
            "ETCUSTD"->{ }


        }

    }
}