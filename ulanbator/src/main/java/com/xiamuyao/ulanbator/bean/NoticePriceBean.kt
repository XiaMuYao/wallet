package com.xiamuyao.ulanbator.bean

import androidx.databinding.BaseObservable
import java.io.Serializable

class NoticePriceBean(tag: String) :  Serializable, BaseObservable() {
    var Id: String? = null
    var curId: String? = null
    var bs: String? = null
    var orderPrice: String? = null
    var getStamp: String? = null
    var cxlStamp: String? = null
    var timestamp: String? = null

}