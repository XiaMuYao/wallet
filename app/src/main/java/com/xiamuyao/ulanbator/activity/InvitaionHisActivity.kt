package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityInvitaionhisBinding
import com.xiamuyao.ulanbator.viewmodel.InvitaionHisViewModel


class InvitaionHisActivity : BaseActivity<ActivityInvitaionhisBinding, InvitaionHisViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_invitaionhis
    }

    override fun initVariableId(): Int {
        return BR.invitaionhisViewModel
    }

    override fun initViewModel(): Class<InvitaionHisViewModel> {
        return InvitaionHisViewModel::class.java
    }

}