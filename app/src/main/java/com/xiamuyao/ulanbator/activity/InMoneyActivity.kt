package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityInmoneyBinding
import com.xiamuyao.ulanbator.viewmodel.InMoneyViewModel


/**
 * 钱包收款
 */
class InMoneyActivity : BaseActivity<ActivityInmoneyBinding, InMoneyViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_inmoney
    }

    override fun initVariableId(): Int {
        return BR.inmoneyViewModel
    }

    override fun initViewModel(): Class<InMoneyViewModel> {
        return InMoneyViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = null) {
            val starter = Intent(context, InMoneyActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}