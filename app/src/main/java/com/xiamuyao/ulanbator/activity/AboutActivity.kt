package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityAboutBinding
import com.xiamuyao.ulanbator.viewmodel.AboutViewModel


class AboutActivity : BaseActivity<ActivityAboutBinding, AboutViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_about
    }

    override fun initVariableId(): Int {
        return BR.aboutViewModel
    }

    override fun initViewModel(): Class<AboutViewModel> {
        return AboutViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, AboutActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }


}