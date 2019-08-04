package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.activity.ForgetActivity
import com.xiamuyao.ulanbator.activity.SendSuccessActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.repository.MoneyRepository
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.model.repository.WalletRepository
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
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

    override fun initData() {
        tel.value = getSpValue("tel", "")

    }

    fun sendCode() {
        launch {
            userRepository.sendTheVerificationCode(5.toString(), getSpValue("dialingCode", ""), tel.value!!)
            sendCodeType.call()
        }

    }

    fun forgetPassword() {
        startActivity(ForgetActivity::class.java)
    }

    fun send() {
        launch {
            var addressd = ""
            addressd = if (type.value!!){
                address.value+","+memoAddress.value
            }else{
                address.value!!
            }
            val modifyTheFundPassword =
                repository.transfer(
                    pairType.value!!,
                    phoneCode.value!!,
                    addressd,
                    money.value!!,
                    fundPassword.value!!
                )

            businessHandler(modifyTheFundPassword) {
                if (modifyTheFundPassword.result.returnCode == "0") {
                    startActivity(
                        SendSuccessActivity::class.java,
                        bundleOf("type" to type.value, "pairName" to pairName.value, "money" to money.value)
                    )
                }
            }

        }
    }

}