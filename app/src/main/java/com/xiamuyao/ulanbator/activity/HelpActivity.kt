package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityHelpBinding
import com.xiamuyao.ulanbator.viewmodel.HelpViewModel


class HelpActivity : BaseActivity<ActivityHelpBinding, HelpViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_help
    }

    override fun initVariableId(): Int {
        return BR.helpViewModel
    }

    override fun initViewModel(): Class<HelpViewModel> {
        return HelpViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, HelpActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}