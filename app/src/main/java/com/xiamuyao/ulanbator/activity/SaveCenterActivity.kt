package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySavecenterBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SaveCenterViewModel


class SaveCenterActivity : BaseActivity<ActivitySavecenterBinding, SaveCenterViewModel>() {

    override fun initView() {
        setTitleBar("安全中心", { finish() })

        //修改登录密码
        binding.constraintLayout5.setOnClickListener {SetUserPsdActivity.start(this) }
        //修改登录密码
        binding.constraintLayout6.setOnClickListener {SetMoneyPsdActivity.start(this) }

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