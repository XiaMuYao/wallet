package com.xiamuyao.sample.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel

class ImageShowViewModel(application: Application) : BaseViewModel(application) {
    var imageUrl = MutableLiveData<String>()
    override fun initData() {
    }
}