package com.xiamuyao.ulanbator.model.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class MarketBean : BaseObservable() {

    /**
     * ch : market.btcusdt.detail
     * ts : 1564064602548
     * tick : {"id":101885471578,"low":9520.6,"high":10180,"open":9794.17,"close":9998.4,"vol":3.4729198214034975E8,"amount":35044.36531612962,"version":101885471578,"count":313144}
     */

    private var ch: String = ""
    private var ts: String = ""
    private var tick: TickBean? = null

    fun getCh(): String? {
        return ch
    }

    fun setCh(ch: String) {
        this.ch = ch
    }

    fun getTs(): String {
        return ts
    }

    fun setTs(ts: String) {
        this.ts = ts
    }

    fun getTick(): TickBean? {
        return tick
    }

    fun setTick(tick: TickBean) {
        this.tick = tick
    }

    class TickBean : BaseObservable() {
        /**
         * id : 101885471578
         * low : 9520.6
         * high : 10180.0
         * open : 9794.17
         * close : 9998.4
         * vol : 3.4729198214034975E8
         * amount : 35044.36531612962
         * version : 101885471578
         * count : 313144
         */

        @get:Bindable
        var id: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.id)
            }
        @get:Bindable
        var low: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.low)
            }
        @get:Bindable
        var high: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.high)
            }
        @get:Bindable
        var open: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.open)
            }
        @get:Bindable
        var close: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.close)
            }
        @get:Bindable
        var vol: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.vol)
            }
        @get:Bindable
        var amount: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.amount)
            }
        @get:Bindable
        var version: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.version)
            }
        @get:Bindable
        var count: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.count)
            }

        @get:Bindable
        var cch: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.cch)
            }

        @get:Bindable
        var pairName: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.pairName)
            }
        @get:Bindable
        var pairToPrice: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.pairToPrice)
            }

        @get:Bindable
        var upAndDown: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.upAndDown)
            }
        @get:Bindable
        var pairAndToName: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.pairAndToName)
            }

        @get:Bindable
        var rose: String = ""
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.rose)
            }


        @get:Bindable
        var toKRW: String = "1"
            set(sex) {
                field = sex
                notifyPropertyChanged(BR.toKRW)
            }

        //只是显示 没有其他作用 不可用
        @get:Bindable
        var pairToName: String = "USDT"
    }

}
