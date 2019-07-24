package com.xiamuyao.ulanbator.model.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class WalletListBean: BaseObservable() {
    var id: Int = -1
    var pairName: String = ""
    var pairImage: String = ""
    var pairToName: String = ""
    var pariPrice: String = ""
    var pariToPrice: String = ""
    @get:Bindable
    var showHide: Boolean? = null
        set(sex) {
            field = sex
            notifyPropertyChanged(BR.showHide)
        }
}