package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityTransferaccountsBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.TransferAccountsViewModel

/**
 * 转账界面
 */
class TransferAccountsActivity : BaseActivity<ActivityTransferaccountsBinding, TransferAccountsViewModel>() {

    override fun initView() {
        setTitleBar("EOS转账", { finish() }, rightCallBack = { finish() })

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_transferaccounts
    }

    override fun initVariableId(): Int {
        return BR.transferaccountsViewModel
    }

    override fun initViewModel(): Class<TransferAccountsViewModel> {
        return TransferAccountsViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, TransferAccountsActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}