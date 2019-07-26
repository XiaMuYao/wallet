package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityRegisterBinding
import com.xiamuyao.ulanbator.viewmodel.RegisterViewModel


class RegisterActivity : BaseActivity<ActivityRegisterBinding, RegisterViewModel>() {

    override fun initView() {
        setTextAndClick(R.id.titleBarRightText, "登陆") { LoginActivity.start(this) }
    }

    override fun initVVMObserver() {
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