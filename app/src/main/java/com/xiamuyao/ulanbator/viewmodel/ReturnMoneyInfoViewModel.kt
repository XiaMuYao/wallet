package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.model.bean.ReturnMoneyInfoBean
import com.xiamuyao.ulanbator.model.repository.MyUserRepository
import com.xiamuyao.ulanbator.util.businessHandler
import com.xiamuyao.ulanbator.util.toTime
import org.kodein.di.generic.instance

class ReturnMoneyInfoViewModel(application: Application) : BaseViewModel(application) {

    var returnMoneyInfoHis = ObservableArrayList<ReturnMoneyInfoBean>()
    var itemId = MutableLiveData<String>()

    var sum = MutableLiveData<String>()
    var userName = MutableLiveData<String>()
    var userType = MutableLiveData<String>()

    private val myRepository: MyUserRepository by instance()

    override fun initData() {

    }

    fun getPageData() {
        launch {
            val rebateDetails = myRepository.getRebateDetails(itemId.value!!, "0", Int.MAX_VALUE.toString())
            businessHandler(rebateDetails) {
                val data = rebateDetails.data

                data.list.forEach {

                    var returnMoneyInfoBean = ReturnMoneyInfoBean()
                    returnMoneyInfoBean.time = it.createTime.toTime()!!
                    returnMoneyInfoBean.type = it.operationTypeText
                    returnMoneyInfoBean.money = it.amount + " MFT"
                    returnMoneyInfoHis.add(returnMoneyInfoBean)

                }
                sum.value = data.list.size.toString()
                userName.value = data.nickname
                userType.value = "VIP"+data.vipType
            }


        }

    }

}