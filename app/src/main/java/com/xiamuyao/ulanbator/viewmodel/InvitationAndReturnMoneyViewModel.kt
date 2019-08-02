package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import org.kodein.di.generic.instance

class InvitationAndReturnMoneyViewModel(application: Application) : BaseViewModel(application) {

    private val myRepository: MyUserRepository by instance()

    var userNeme = MutableLiveData<String>()
    var userid = MutableLiveData<String>()
    var userLever = MutableLiveData<Int>()
    var cumulativeRebate = MutableLiveData<String>()
    var totalNumberOfInvitations = MutableLiveData<String>()

    var generalUser = MutableLiveData<String>()
    var vip1 = MutableLiveData<String>()
    var vip2 = MutableLiveData<String>()
    var vip3 = MutableLiveData<String>()
    var vip4 = MutableLiveData<String>()
    var vip5 = MutableLiveData<String>()

    override fun initData() {
        getInfo()
    }

    fun getInfo() {
        launch {
            val invitationRebateStatistics = myRepository.getInvitationRebateStatistics()
            businessHandler(invitationRebateStatistics) {
                with(invitationRebateStatistics.data) {
                    userNeme.value = nickname
                    userid.value = "ID $inviteCode"
                    userLever.value = vipType
                    cumulativeRebate.value = inviteInterest
                    totalNumberOfInvitations.value = userQtyALL

                    generalUser.value = sum
                    vip1.value = userQtyVip1
                    vip2.value = userQtyVip2
                    vip3.value = userQtyVip3
                    vip4.value = userQtyVip4
                    vip5.value = userQtyVip5
                }

            }
        }
    }

}