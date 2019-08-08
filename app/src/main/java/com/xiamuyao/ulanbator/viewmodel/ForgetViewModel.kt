package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.activity.SelectCityActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.To
import org.kodein.di.generic.instance

class ForgetViewModel(application: Application) : BaseViewModel(application) {
    var phoneNum = MutableLiveData<String>()
    var selectCityName = MutableLiveData<String>()
    var selectCityNum = MutableLiveData<String>()
    var phoneCode = MutableLiveData<String>()
    var accountPsd = MutableLiveData<String>()
    var accountPsdConfirm = MutableLiveData<String>()
    var sendCodeType = SingleLiveEvent<Boolean>()
    var showOrHideDialog = SingleLiveEvent<Boolean>()

    private val userRepository: UserRepository by instance()


    init {
        selectCityName.value = ""
        selectCityNum.value = ""
        showOrHideDialog.value = false
    }


    override fun initData() {
        launch {
            selectCityName.value = userRepository.getCityList()[0].showCityName
            selectCityNum.value = userRepository.getCityList()[0].dialingCode
        }
    }

    /**
     * 发送验证码
     */
    fun sendCode() {
        if (phoneNum.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.pleaseInoutPhoe))
            return
        }
        launch {
            showOrHideDialog.value = true
            businessHandler(userRepository.sendTheVerificationCode("2", selectCityNum.value!!, phoneNum.value!!)) {
                sendCodeType.call()


            }
            showOrHideDialog.value = false
        }
    }

    /**
     * 选择国家
     */
    fun selectCity(){
        startActivity(SelectCityActivity::class.java)
    }

    fun forgetPassword() {
        if (phoneNum.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.pleaseInoutPhoe))
            return
        }
        if (accountPsd.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.pleaseInPutPsd))
            return
        }
        if (accountPsdConfirm.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.pleaseInPutPsdConig))
            return
        }
        if (accountPsdConfirm.value!= accountPsd.value){
            To.showToast(context.getString(R.string.pasdno))
            return
        }
        if (phoneCode.value.isNullOrEmpty()){
            To.showToast(context.getString(R.string.inphoneCode))
            return
        }

        launch {
            businessHandler(userRepository.forgetPassword(selectCityNum.value!!, phoneNum.value!!, accountPsd.value!!,accountPsdConfirm.value!!,phoneCode.value!!)){
                startActivity(MainActivity::class.java)
                finishStatus.call()
            }
        }
    }
}