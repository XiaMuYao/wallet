package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySetuserpsdBinding
import com.xiamuyao.ulanbator.util.CountTime
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SetUserPsdViewModel


/**
 * 修改登录密码
 */
class SetUserPsdActivity : BaseActivity<ActivitySetuserpsdBinding, SetUserPsdViewModel>() {

    override fun initView() {
        setTitleBar(title = getString(R.string.xiugaidenglumima), leftCallBack = { finish() })

    }

    override fun initVVMObserver() {
        //倒计时
        val countTime = CountTime(textView = binding.phoneCode)

        viewModel.sendCodeType.observe(this, Observer {

            if (!countTime.start) {
                countTime.start()
            }

        })
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