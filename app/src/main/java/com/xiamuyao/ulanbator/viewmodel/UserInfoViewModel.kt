package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.activity.LoginActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.util.UsetUtli
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.SingleLiveEvent
import com.xiamuyao.ulanbator.utlis.getSpValue
import com.xiamuyao.ulanbator.utlis.putSpValue
import org.kodein.di.generic.instance

class UserInfoViewModel(application: Application) : BaseViewModel(application) {

    private val userRepository: UserRepository by instance()


    var nickName = MutableLiveData<String>()
    var vipType = MutableLiveData<Int>()
    var inviteCode = MutableLiveData<String>()
    var logonNetType = SingleLiveEvent<Boolean>()


    override fun initData() {
        nickName.value = UsetUtli.getUserName()
        vipType.value = getSpValue("vipType", 0)
        if (UsetUtli.getUserId().isEmpty()) {
            inviteCode.value = ""
        } else {
            inviteCode.value = UsetUtli.getUserId()
        }
    }

    fun logout() {
        logonNetType.call()
    }

    fun logoutNet() {
        launch {
            val quit = userRepository.quit()

            businessHandler(quit) {
                startActivity(LoginActivity::class.java)
                App.CONTEXT.putSpValue(ProjectConstant.USER_TOKEN, "")
                ActivityStackManager.getInstance().finishAllActivity()

            }
        }
    }

}