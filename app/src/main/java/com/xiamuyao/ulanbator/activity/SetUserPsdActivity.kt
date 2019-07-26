package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySetuserpsdBinding
import com.xiamuyao.ulanbator.viewmodel.SetUserPsdViewModel


class SetUserPsdActivity : BaseActivity<ActivitySetuserpsdBinding, SetUserPsdViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_setuserpsd
    }

    override fun initVariableId(): Int {
        return BR.setuserpsdViewModel
    }

    override fun initViewModel(): Class<SetUserPsdViewModel> {
        return SetUserPsdViewModel::class.java
    }

}