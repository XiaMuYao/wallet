package com.xiamuyao.ulanbator.net


data class BaseResponse<out T>(val result: ResultBean, val data: T)

class ResultBean {
    /**
     * returnCode : 0
     * returnUserMessage : 成功
     * returnMessage : 成功
     */

    var returnCode: String? = null
    var returnUserMessage: String? = null
    var returnMessage: String? = null
}