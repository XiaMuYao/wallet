package com.xiamuyao.sample.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.utlis.LL
import com.xiamuyao.ulanbator.utlis.LibConstant

class ShowBigImageViewModel(application: Application) : BaseViewModel(application) {

    var index = MutableLiveData<Int>()
    var imageList = ObservableArrayList<String>()

    override fun initData() {
    }

}