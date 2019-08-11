package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.FirstSetMonPsdActivity
import com.xiamuyao.ulanbator.activity.ForgetActivity
import com.xiamuyao.ulanbator.activity.SendSuccessActivity
import com.xiamuyao.ulanbator.activity.SetMoneyPsdActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.getSpValue
import org.kodein.di.generic.instance

class SendInfoViewModel(application: Application) : BaseViewModel(application) {
    private val userRepository: UserRepository by instance()
    private val repository: WalletRepository by instance()


    var money = MutableLiveData<String>()
    var address = MutableLiveData<String>()
    var memoAddress = MutableLiveData<String>()
    var userSymbolFeeRate = MutableLiveData<String>()
    var pairName = MutableLiveData<String>()
    var pairType = MutableLiveData<String>()
    var type = MutableLiveData<Boolean>()

    var fundPassword = MutableLiveData<String>()
    var phoneCode = MutableLiveData<String>()
    var tel = MutableLiveData<String>()
    var sendCodeType = SingleLiveEvent<Boolean>()
    var showOrHideDialog = SingleLiveEvent<Boolean>()
    init {

        showOrHideDialog.value = false




    }
    override fun initData() {
        tel.value = getSpValue("tel", "")

    }

    fun sendCode() {
        launch {
            showOrHideDialog.value = true
            userRepository.sendTheVerificationCode(5.toString(), getSpValue("dialingCode", ""), tel.value!!)
            sendCodeType.call()
            showOrHideDialog.value = false
        }

    }

    fun forgetPassword() {
        startActivity(SetMoneyPsdActivity::class.java)
    }

    fun send() {
        launch {
            var addressd = ""
            addressd = if (type.value!!){
                address.value+","+memoAddress.value
            }else{
                address.value!!
            }
            showOrHideDialog.value = true

            val modifyTheFundPassword =
                repository.transfer(
                    pairType.value!!,
                    phoneCode.value!!,
                    addressd,
                    money.value!!.replace(",",""),
                    fundPassword.value!!
                )

            businessHandler(modifyTheFundPassword) {
                if (modifyTheFundPassword.result.returnCode == "0") {
                    startActivity(
                        SendSuccessActivity::class.java,
                        bundleOf("type" to type.value, "pairName" to pairName.value, "money" to money.value,"shouSuccessText" to App
                            .CONTEXT.getString(R.string.sendsucess))
                    )
                }
            }
            showOrHideDialog.value = false


        }
    }

}