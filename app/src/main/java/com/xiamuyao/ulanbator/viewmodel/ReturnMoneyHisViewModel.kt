package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.ReturnMoneyHisBean
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.util.businessHandler
import org.kodein.di.generic.instance

class ReturnMoneyHisViewModel(application: Application) : BaseViewModel(application) {

    var returnMoneyHis = ObservableArrayList<ReturnMoneyHisBean>()

    private val myRepository: MyUserRepository by instance()

    override fun initData() {
        launch {
            val aRebateRecord = myRepository.getARebateRecord("", "")
            businessHandler(aRebateRecord) {

                aRebateRecord.data.list.forEach {
                    val returnMoneyHisBean = ReturnMoneyHisBean()
                    returnMoneyHisBean.id = it.inviteCode
                    returnMoneyHisBean.returnMoneyType = "VIP " + it.vipType
                    returnMoneyHisBean.invataionOption = "详情"
                    returnMoneyHisBean.returnMoneyNum = it.commissionSum.toString()
                    returnMoneyHis.add(returnMoneyHisBean)
                }
            }


        }
    }

}