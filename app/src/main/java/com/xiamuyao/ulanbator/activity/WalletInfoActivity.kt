package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityWalletinfoBinding
import com.xiamuyao.ulanbator.viewmodel.WalletInfoViewModel


class WalletInfoActivity : BaseActivity<ActivityWalletinfoBinding, WalletInfoViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }

    override fun initData() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_walletinfo
    }

    override fun initVariableId(): Int {
        return BR.walletinfoViewModel
    }

    override fun initViewModel(): Class<WalletInfoViewModel> {
        return WalletInfoViewModel::class.java
    }

}