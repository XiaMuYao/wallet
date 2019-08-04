package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySendsuccessBinding
import com.xiamuyao.ulanbator.viewmodel.SendSuccessViewModel

/**
 * 发送成功
 */
class SendSuccessActivity : BaseActivity<ActivitySendsuccessBinding, SendSuccessViewModel>() {

    override fun initView() {
        viewModel.money.value = intent.getStringExtra("money")
        viewModel.pairName.value = intent.getStringExtra("pairName")

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_sendsuccess
    }

    override fun initVariableId(): Int {
        return BR.sendsuccessViewModel
    }

    override fun initViewModel(): Class<SendSuccessViewModel> {
        return SendSuccessViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, SendSuccessActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}