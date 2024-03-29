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
import com.xiamuyao.ulanbator.databinding.ActivityForgetBinding
import com.xiamuyao.ulanbator.util.CountTime
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.viewmodel.ForgetViewModel


class ForgetActivity : BaseActivity<ActivityForgetBinding, ForgetViewModel>() {

    override fun initView() {
        setTitleBar(
            leftCallBack = { finish() },
            titleBarColor = R.color.touming,
            rightText = App.CONTEXT.getString(R.string.register),
            rightCallBack = { RegisterActivity.start(this) })


        val countTime = CountTime(textView = binding.phoneCode)
        binding.phoneCode.setOnClickListener {
            if (!countTime.start) {
                countTime.start()
            }
        }
    }

    override fun initVVMObserver() {

        //倒计时
        val countTime = CountTime(textView = binding.phoneCode)

        viewModel.sendCodeType.observe(this, Observer {

            if (!countTime.start) {
                countTime.start()
            }

        })

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

    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_forget
    }

    override fun initVariableId(): Int {
        return BR.forgetViewModel
    }

    override fun initViewModel(): Class<ForgetViewModel> {
        return ForgetViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = null) {
            val starter = Intent(context, ForgetActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}