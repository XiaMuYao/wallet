package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityInvitationandreturnmoneyBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.InvitationAndReturnMoneyViewModel


/**
 * 邀请返佣
 */
class InvitationAndReturnMoneyActivity :
    BaseActivity<ActivityInvitationandreturnmoneyBinding, InvitationAndReturnMoneyViewModel>() {

    override fun initView() {
        setTitleBar("邀请返佣", { finish() },rightText = "邀请规则")

    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_invitationandreturnmoney
    }

    override fun initVariableId(): Int {
        return BR.invitationandreturnmoneyViewModel
    }

    override fun initViewModel(): Class<InvitationAndReturnMoneyViewModel> {
        return InvitationAndReturnMoneyViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, InvitationAndReturnMoneyActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}