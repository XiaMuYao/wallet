package com.xiamuyao.ulanbator.model.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import java.io.Serializable

class WalletListBean(
    var pairName: String = "",
    var pariAmount: String = "",
    var pariId: String = "",
    var pariImage: String = "",
    pariToPrice: String = "0",
    var pairToName: String = "",
    var pairToUSDT: String = "0",
    var PairToBTC: String = "0",
    //显示得计价货币
     mshowPair: String = "",
    //当前对USDT
    var  PairToUSDTPrice: String = "0"
) : BaseObservable() ,Serializable {
    @get:Bindable
    var showHide: Boolean? = true
        set(sex) {
            field = sex
            notifyPropertyChanged(BR.showHide)
        }

    @get:Bindable
    var pariToPrice: String? =pariToPrice
        set(sex) {
            field = sex
            notifyPropertyChanged(BR.pariToPrice)
        }
    @get:Bindable
    var showPair: String? =mshowPair
        set(sex) {
            field = sex
            notifyPropertyChanged(BR.showPair)
        }



}