package com.xiamuyao.ulanbator.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.xiamuyao.ulanbator.utlis.LL
import com.xiamuyao.ulanbator.utlis.LibConstant
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class BaseViewModel(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein by closestKodein(application)

    //上下文
    val context = application
    //结束页面
    val finishStatus = SingleLiveEvent<Boolean>()
    //显示Dialog
    val showDialogStatus = SingleLiveEvent<Boolean>()
    //销毁Dialog
    val disDialogStatus = SingleLiveEvent<Boolean>()

    abstract fun initData()

    open fun <T> launch(block: suspend () -> T) = viewModelScope.launch {
        try {
            block()
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

}