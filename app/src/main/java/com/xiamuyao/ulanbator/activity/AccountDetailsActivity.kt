package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityAccountdetailsBinding
import com.xiamuyao.ulanbator.viewmodel.AccountDetailsViewModel


class AccountDetailsActivity : BaseActivity<ActivityAccountdetailsBinding, AccountDetailsViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_accountdetails
    }

    override fun initVariableId(): Int {
        return BR.accountdetailsViewModel
    }

    override fun initViewModel(): Class<AccountDetailsViewModel> {
        return AccountDetailsViewModel::class.java
    }

}