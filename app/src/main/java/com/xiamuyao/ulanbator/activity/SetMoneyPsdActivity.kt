package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySetmoneypsdBinding
import com.xiamuyao.ulanbator.viewmodel.SetMoneyPsdViewModel


class SetMoneyPsdActivity : BaseActivity<ActivitySetmoneypsdBinding, SetMoneyPsdViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_setmoneypsd
    }

    override fun initVariableId(): Int {
        return BR.setmoneypsdViewModel
    }

    override fun initViewModel(): Class<SetMoneyPsdViewModel> {
        return SetMoneyPsdViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String?) {
            val starter = Intent(context, SetMoneyPsdActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}