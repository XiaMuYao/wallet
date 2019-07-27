package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityAccountdetailsBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.AccountDetailsViewModel


/**
 * 累计总收益
 */
class AccountDetailsActivity : BaseActivity<ActivityAccountdetailsBinding, AccountDetailsViewModel>() {

    override fun initView() {
        setTitleBar(titleBarColor = R.color.touming, leftCallBack = { finish() })
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

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, AccountDetailsActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}