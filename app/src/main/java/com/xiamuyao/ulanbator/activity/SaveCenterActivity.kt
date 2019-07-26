package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySavecenterBinding
import com.xiamuyao.ulanbator.viewmodel.SaveCenterViewModel


class SaveCenterActivity : BaseActivity<ActivitySavecenterBinding, SaveCenterViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_savecenter
    }

    override fun initVariableId(): Int {
        return BR.savecenterViewModel
    }

    override fun initViewModel(): Class<SaveCenterViewModel> {
        return SaveCenterViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, SaveCenterActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}