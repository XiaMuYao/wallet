package com.xiamuyao.ulanbator.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.MainActivity
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.extension.businessHandler
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.utlis.To
import org.kodein.di.generic.instance

class FirstSetMonPsdViewModel(application: Application) : BaseViewModel(application) {

    private val userRepository: UserRepository by instance()

    var moneyPsd = MutableLiveData<String>()
    var moneyPsdAgren = MutableLiveData<String>()

    override fun initData() {

    }

    fun gotoMainActivity(){
        if (moneyPsd.value.isNullOrEmpty()){
            To.showToast(context.getString(R.string.pleadzijinmima))
            return
        }

        if (moneyPsdAgren.value.isNullOrEmpty()){
            To.showToast(context.getString(R.string.pldeazijinagre))
            return
        }
        if (moneyPsdAgren.value!=moneyPsd.value){
            To.showToast(context.getString(R.string.liangcinoagen))
            return
        }

        launch {
            businessHandler(userRepository.setTransactionPassword(moneyPsd.value!!,moneyPsdAgren.value!!)){
                startActivity(MainActivity::class.java)
                ActivityStackManager.getInstance().finishAllActivity()

                finishStatus.call()
            }

        }
    }
}