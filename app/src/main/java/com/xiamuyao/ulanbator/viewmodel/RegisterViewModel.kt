package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.FirstSetMonPsdActivity
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.activity.PrivacyActivity
import com.xiamuyao.ulanbator.activity.SelectCityActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.response.CityListBean
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.Md5
import com.xiamuyao.ulanbator.util.RateUtli
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.To
import org.kodein.di.generic.instance

class RegisterViewModel(application: Application) : BaseViewModel(application) {

    var registerSelect = MutableLiveData<Boolean>()
    var selectCityName = MutableLiveData<String>()
    var selectCityNum = MutableLiveData<String>()
    var countryCode = MutableLiveData<String>()
    var phoneNum = MutableLiveData<String>()
    var phoneCode = MutableLiveData<String>()
    var accountPsd = MutableLiveData<String>()
    var accountPsdConfirm = MutableLiveData<String>()
    var invitationCode = MutableLiveData<String>()
    var sendCodeType = SingleLiveEvent<Boolean>()

    private val userRepository: UserRepository by instance()

    var showOrHideDialog = SingleLiveEvent<Boolean>()
    init {
        registerSelect.value = false
        invitationCode.value = ""

        selectCityName.value = ""
        selectCityNum.value = ""
        countryCode.value = ""
    }

    override fun initData() {


        launch {
            selectCityName.value = userRepository.getCityList()[0].showCityName
            selectCityNum.value = userRepository.getCityList()[0].dialingCode
            countryCode.value = userRepository.getCityList()[0].countryCode
        }


    }

    /**
     * 注册
     */
    fun registerUse() {
        if (!registerSelect.value!!) {
            To.showToast(context.getString(R.string.agranRegister))
            return
        }
        if (accountPsd.value != accountPsdConfirm.value) {
            To.showToast(context.getString(R.string.pasdno))
            return
        }
        if (phoneNum.value.isNullOrEmpty() ||
            phoneCode.value.isNullOrEmpty() ||
            accountPsd.value.isNullOrEmpty() ||
            accountPsdConfirm.value.isNullOrEmpty()
        ) {
            To.showToast(context.getString(R.string.datanull))
            return
        }

        launch {
            businessHandler(
                userRepository.register(
                    countryCode.value!!,
                    selectCityNum.value!!,
                    phoneNum.value!!,
                    Md5.getMD5(accountPsd.value!!),
                    Md5.getMD5(accountPsdConfirm.value!!),
                    phoneCode.value!!,
                    invitationCode.value!!
                )
            )
            {
                startActivity(FirstSetMonPsdActivity::class.java)
            }


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

            businessHandler(userRepository.sendTheVerificationCode("1", selectCityNum.value!!, phoneNum.value!!)) {
                sendCodeType.call()


            }
            showOrHideDialog.value = false
        }
    }

    fun selectRegister() {
        registerSelect.value = registerSelect.value?.not()
    }

    fun gotoSelectCity() {
        startActivity(SelectCityActivity::class.java)
    }

    fun gotoPrivacyActivity() {
        startActivity(PrivacyActivity::class.java)
    }
}