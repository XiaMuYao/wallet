package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.activity.LoginActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import org.kodein.di.generic.instance

class SetUserPsdViewModel(application: Application) : BaseViewModel(application) {

    private val repository: MyUserRepository by instance()
    private val userRepository: UserRepository by instance()

    var loginPassword = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var passwordConfirm = MutableLiveData<String>()
    var verifyCode = MutableLiveData<String>()
    var tel = MutableLiveData<String>()
    var sendCodeType = SingleLiveEvent<Boolean>()
    var showOrHideDialog = SingleLiveEvent<Boolean>()
    override fun initData() {
        tel.value = getSpValue("tel", "")
        showOrHideDialog.value = false
    }

    fun setLoginPsd() {
        launch {
            val modifyTheLoginPassword = repository.modifyTheLoginPassword(
                loginPassword.value!!,
                password.value!!,
                passwordConfirm.value!!,
                verifyCode.value!!
            )



            businessHandler(modifyTheLoginPassword) {
                startActivity(LoginActivity::class.java)
                ActivityStackManager.getInstance().finishAllActivity()
            }

        }
    }

    fun sendCde() {
        launch {
            showOrHideDialog.value = true
            userRepository.sendTheVerificationCode(3.toString(), getSpValue("dialingCode", ""), tel.value!!)
            sendCodeType.call()
            showOrHideDialog.value = false
        }
    }

}