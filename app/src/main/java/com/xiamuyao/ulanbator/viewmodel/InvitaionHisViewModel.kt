package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.InvataionListBean

class InvitaionHisViewModel(application: Application) : BaseViewModel(application) {

    var invitaionHis = ObservableArrayList<InvataionListBean>()

    override fun initData() {

        for (i in 0..10) {
            invitaionHis.add(InvataionListBean())
        }
    }

}