package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant.finsh
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.DataBus

class SendSuccessViewModel(application: Application) : BaseViewModel(application) {

    var money = MutableLiveData<String>()
    var pairName = MutableLiveData<String>()
    var showText = MutableLiveData<String>()
    var shouSuccessText = MutableLiveData<String>()


    override fun initData() {
        showText.value = money.value + pairName.value
    }

    fun finshthis() {
//        startActivity(MainActivity::class.java, bundleOf("index" to 3))
//        ActivityStackManager.getInstance().finishAllActivity()
        DataBus.postData(finsh,finsh)
        finishStatus.call()
    }
}
