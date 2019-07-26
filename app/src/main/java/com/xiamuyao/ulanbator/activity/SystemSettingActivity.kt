package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySystemsettingBinding
import com.xiamuyao.ulanbator.viewmodel.SystemSettingViewModel


class SystemSettingActivity : BaseActivity<ActivitySystemsettingBinding, SystemSettingViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_systemsetting
    }

    override fun initVariableId(): Int {
        return BR.systemsettingViewModel
    }

    override fun initViewModel(): Class<SystemSettingViewModel> {
        return SystemSettingViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, SystemSettingActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}