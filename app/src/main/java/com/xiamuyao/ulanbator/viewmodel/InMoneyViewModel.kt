package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import android.content.ClipData
import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.king.zxing.util.CodeUtils
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.To
import org.kodein.di.generic.instance
import android.content.ClipData.newPlainText
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import com.xiamuyao.ulanbator.util.UsetUtli
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.getSpValue


class InMoneyViewModel(application: Application) : BaseViewModel(application) {

    private val repository: WalletRepository by instance()
    var pairType = MutableLiveData<String>()
    var pairName = MutableLiveData<String>()
    var momoAddress = MutableLiveData<String>()
    var pairAddress = MutableLiveData<String>()
    var addressBitMap: Bitmap? = null
    var loadOk = SingleLiveEvent<Boolean>()
    var copy = SingleLiveEvent<Boolean>()

    var nickName = MutableLiveData<String>()
    var vipType = MutableLiveData<Int>()
    var inviteCode = MutableLiveData<String>()

    var pageType = MutableLiveData<Boolean>()

    override fun initData() {
        nickName.value = UsetUtli.getUserName()
        vipType.value = App.CONTEXT.getSpValue("vipType", 0)
        inviteCode.value = UsetUtli.getUserId()
    }

    fun getPageData() {
        launch {
            val userWalletAddress = repository.getUserWalletAddress(pairType.value!!)

            businessHandler(userWalletAddress) {
                val data = userWalletAddress.data
                val split = data.userWalletAddress.split(",")
                if (split.size > 1) {
                    pairAddress.value = split[0]
                    momoAddress.value = "Memo" + split[1]
                    pageType.value = true
                } else {
                    pairAddress.value = split[0]
                    pageType.value = false
                }

                addressBitMap = CodeUtils.createQRCode(data.userWalletAddress, 500)
                loadOk.call()
            }
        }
    }

    fun copyAddress() {
        copy.call()
    }

}