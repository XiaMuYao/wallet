package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class ShowPhotoViewModel(application: Application) : BaseViewModel(application) {
    //图片地址
    var imageList: ArrayList<String> = arrayListOf()
    //图片下标
    var imageIndex = MutableLiveData<Int>()

    override fun initData() {

    }

}