package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.util.DataUtli
import com.xiamuyao.ulanbator.base.BaseViewModel

class HotViewModel(application: Application) : BaseViewModel(application) {

    var hotPageFragmentTitle: List<String> = DataUtli.getHotPageList()

    var textStr = MutableLiveData<String>()

    override  fun initData() {
    }

}