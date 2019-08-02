package com.xiamuyao.ulanbator.constant

/**
 * 系统常量
 */
object ProjectConstant {

    const val BASE_URL = "http://3.113.121.236:8080/maxflow/"
    const val IMAGE_URL = "http://pic41.nipic.com/20140508/18609517_112216473140_2.jpg"
    //    const val WX_ADDRESS = "wss://ws.bition.pro/kline-api/ws"
    const val WX_ADDRESS = "wss://api.huobipro.com/ws"
    /**
     * 订阅行情数据
     */
    const val SUB_STR_BTC = "{\n" + "  \"sub\": \"market.btcusdt.detail\"\n" + "}"
    const val SUB_STR_ETH = "{\n" + "  \"sub\": \"market.ethusdt.detail\"\n" + "}"
    const val SUB_STR_LTC = "{\n" + "  \"sub\": \"market.ltcusdt.detail\"\n" + "}"
    const val SUB_STR_EOS = "{\n" + "  \"sub\": \"market.eosusdt.detail\"\n" + "}"
    const val SUB_STR_ETC = "{\n" + "  \"sub\": \"market.etcusdt.detail\"\n" + "}"

    const val USER_TOKEN = "userLoginToken"
    //BTC 价格
    const val BTC_PRICE = "BTC_PRICE"

    // 内存中的计价货币
    var inMemoryCurrency = ""
//     内存中的计价货币对应的汇率
    var USDTToExchangeRate= "0"

}