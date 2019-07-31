package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.util.getSpValue

class UserInfoViewModel(application: Application) : BaseViewModel(application) {


    var nickName = MutableLiveData<String>()
    var vipType = MutableLiveData<Int>()
    var inviteCode = MutableLiveData<String>()


    override fun initData() {
        nickName.value = getSpValue("nickname", "")
        vipType.value = getSpValue("vipType", 0)
        if (getSpValue("inviteCode", "").isEmpty()) {
            inviteCode.value = ""
        } else {
            inviteCode.value = "ID:${getSpValue("inviteCode", "")}"
        }
    }

}