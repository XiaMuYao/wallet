package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import org.kodein.di.generic.instance

class SetMoneyPsdViewModel(application: Application) : BaseViewModel(application) {
    private val userRepository: UserRepository by instance()
    private val myRepository: MyUserRepository by instance()
    var sendCodeType = SingleLiveEvent<Boolean>()
    var tel = MutableLiveData<String>()

    var password = MutableLiveData<String>()
    var passwordConfirm = MutableLiveData<String>()
    var verifyCode = MutableLiveData<String>()

    override fun initData() {
        tel.value = getSpValue("tel", "")
    }


    /**
     * 修改资金密码
     */
    fun setMoneyPsd() {
        launch {
            val modifyTheFundPassword =
                myRepository.modifyTheFundPassword(password.value!!, passwordConfirm.value!!, verifyCode.value!!)

            businessHandler(modifyTheFundPassword) {
                if (modifyTheFundPassword.result.returnCode == "0") {
                    finishStatus.call()
                }
            }

        }
    }

    /**
     * 发送验证码
     */
    fun sendCode() {
        launch {
            userRepository.sendTheVerificationCode(4.toString(), getSpValue("dialingCode", ""), tel.value!!)
            sendCodeType.call()
        }
    }
}