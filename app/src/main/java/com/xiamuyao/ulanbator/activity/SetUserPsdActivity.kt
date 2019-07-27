package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySetuserpsdBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SetUserPsdViewModel


/**
 * 修改登录密码
 */
class SetUserPsdActivity : BaseActivity<ActivitySetuserpsdBinding, SetUserPsdViewModel>() {

    override fun initView() {
        setTitleBar("修改登录密码", { finish() })

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

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, SetUserPsdActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}