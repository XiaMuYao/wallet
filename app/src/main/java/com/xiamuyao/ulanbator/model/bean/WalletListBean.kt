package com.xiamuyao.ulanbator.model.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class WalletListBean(
    var pairName: String = "",
    var pairImage: String = "",
    var pairToName: String = "",
    var pariPrice: String = "",
    var pariToPrice: String = ""
) : BaseObservable() {
    @get:Bindable
    var showHide: Boolean? = true
        set(sex) {
            field = sex
            notifyPropertyChanged(BR.showHide)
        }
}