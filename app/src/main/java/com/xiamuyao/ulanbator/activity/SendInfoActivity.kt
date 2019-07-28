package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySendinfoBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SendInfoViewModel

/**
 * 发送详情
 */
class SendInfoActivity : BaseActivity<ActivitySendinfoBinding, SendInfoViewModel>() {

    override fun initView() {
        setTitleBar(
            leftCallBack = { finish() },
            title = "发送详情"
        )
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_sendinfo
    }

    override fun initVariableId(): Int {
        return BR.sendinfoViewModel
    }

    override fun initViewModel(): Class<SendInfoViewModel> {
        return SendInfoViewModel::class.java
    }

}