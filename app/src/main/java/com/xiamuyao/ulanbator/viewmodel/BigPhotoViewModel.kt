package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class BigPhotoViewModel(application: Application) : BaseViewModel(application) {
    //图片地址
    var imageUrl = MutableLiveData<String>()

    override fun initData() {

    }

}