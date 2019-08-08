package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.ForgetActivity
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.activity.SelectCityActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.To
import org.kodein.di.generic.instance

class LoginViewModel(application: Application) : BaseViewModel(application) {

    var selectCityName = MutableLiveData<String>()
    var selectCityNum = MutableLiveData<String>()

    var phoneNum = MutableLiveData<String>()
    var userPsd = MutableLiveData<String>()

    private val userRepository: UserRepository by instance()

    init {
        selectCityNum.value = ""
        selectCityName.value = ""
    }

    override fun initData() {

        launch {
            selectCityName.value = userRepository.getCityList()[0].showCityName
            selectCityNum.value = userRepository.getCityList()[0].dialingCode
        }

    }

    fun login() {
        if (phoneNum.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.pleaseInoutPhoe))
            return
        }
        if (userPsd.value.isNullOrEmpty()) {
            To.showToast(context.getString(R.string.pleaseInPutPsd))
            return
        }
        launch {
            businessHandler(userRepository.logIn(selectCityNum.value!!, phoneNum.value!!, userPsd.value!!)){
                startActivity(MainActivity::class.java)
                ActivityStackManager.getInstance().finishAllActivity()

                finishStatus.call()
            }
        }
    }

    /**
     * 选择国家
     */
    fun selectCity(){
        startActivity(SelectCityActivity::class.java)
    }

    /**
     * 忘记密码
     */
    fun forgetPassword(){
        startActivity(ForgetActivity::class.java)
    }

}