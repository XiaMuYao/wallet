package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.ActivityRegisterBinding
import com.xiamuyao.ulanbator.util.CountTime
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.viewmodel.RegisterViewModel

/**
 * 注册
 */
class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override fun initView() {
        setTitleBar(leftCallBack = { finish() }, rightText =App.CONTEXT.getString(R.string.login),
            titleBarColor = R.color.touming,
            rightCallBack = { LoginActivity.start(this) })

    }

    override fun initVVMObserver() {
        DataBus.observeData(this, EventConstant.selectCityName, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectCityName.value = it
            }
        })
        DataBus.observeData(this, EventConstant.selectCityNum, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectCityNum.value = it
            }
        })
        DataBus.observeData(this, EventConstant.countryCode, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.countryCode.value = it
            }
        })
        //倒计时
        val countTime = CountTime(textView = binding.phoneCode)

        viewModel.sendCodeType.observe(this, Observer {

            if (!countTime.start) {
                countTime.start()
            }

        })
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_register
    }

    override fun initVariableId(): Int {
        return BR.registerViewModel
    }

    override fun initViewModel(): Class<RegisterViewModel> {
        return RegisterViewModel::class.java
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, RegisterActivity::class.java)
            // starter.putExtra()
            context.startActivity(starter)
        }
    }
}