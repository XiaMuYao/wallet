package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.InvataionListBean
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.util.toTime
import org.kodein.di.generic.instance

class InvitaionHisViewModel(application: Application) : BaseViewModel(application) {

    private val myRepository: MyUserRepository by instance()

    var invitaionHis = ObservableArrayList<InvataionListBean>()

    override fun initData() {

        launch {
            myRepository.getTheInvitationRecord("", "").data.list.forEach {
                val invataionListBean = InvataionListBean()
                invataionListBean.id = 0
                invataionListBean.invataionID = it.inviteCode

                if (it.vipType == 0) {
                    invataionListBean.invataionLever = context.getString(R.string.putuser)
                } else {
                    invataionListBean.invataionLever = "VIP " + it.vipType.toString()
                }

                invataionListBean.invataionTime = it.createTime.toTime()!!
                invitaionHis.add(invataionListBean)
            }
        }

    }

}