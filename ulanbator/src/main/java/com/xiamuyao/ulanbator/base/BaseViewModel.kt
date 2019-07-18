package com.xiamuyao.ulanbator.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import kotlinx.coroutines.*
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
            showDialogStatus.call()
            block()
            disDialogStatus.call()
        } catch (t: Throwable) {
            disDialogStatus.call()
            t.printStackTrace()
        }
    }

//    private suspend fun tryCatch(
//        tryBlock: suspend CoroutineScope.() -> Unit,
//        catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
//        finallyBlock: suspend CoroutineScope.() -> Unit,
//        handleCancellationExceptionManually: Boolean = false
//    ) {
//        coroutineScope {
//            try {
//                tryBlock()
//            } catch (e: Exception) {
//                if (e !is CancellationException || handleCancellationExceptionManually) {
//                    catchBlock(e)
//                } else {
//                    throw e
//                }
//            } finally {
//                finallyBlock()
//            }
//        }
//    }
}