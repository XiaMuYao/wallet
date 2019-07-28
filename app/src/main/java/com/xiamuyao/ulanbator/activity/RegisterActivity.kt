package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityRegisterBinding
import com.xiamuyao.ulanbator.util.CountTime
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.RegisterViewModel


class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override fun initView() {
        setTitleBar(leftCallBack = { finish() }, rightText = "登录",
            titleBarColor = R.color.touming,
            rightCallBack = { LoginActivity.start(this) })

        //隐私政策
        binding.button.setOnClickListener { PrivacyActivity.start(this) }

        //倒计时
        val countTime = CountTime(textView = binding.phoneCode)
        binding.phoneCode.setOnClickListener {
            if (!countTime.start) {
                countTime.start()
            }
        }
    }

    override fun initVVMObserver() {
        viewModel.settingMoney.observe(this, Observer {

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