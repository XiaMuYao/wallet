package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityPrivacyBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.PrivacyViewModel
import kotlinx.android.synthetic.main.activity_privacy.*


/**
 * 隐私政策
 */
class PrivacyActivity : BaseActivity<ActivityPrivacyBinding, PrivacyViewModel>() {

    override fun initView() {
        setTitleBar(leftCallBack = { finish() },
            title = getString(R.string.yinsizhengce),
                    rightCallBack = { LoginActivity.start(this) })


        yinzitextv8u.movementMethod = ScrollingMovementMethod.getInstance();
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_privacy
    }

    override fun initVariableId(): Int {
        return BR.privacyViewModel
    }

    override fun initViewModel(): Class<PrivacyViewModel> {
        return PrivacyViewModel::class.java
    }
    companion object {
        fun start(context: Context, message: String?=null) {
            val starter = Intent(context, PrivacyActivity::class.java)
            starter.putExtra("message",message)
            context.startActivity(starter)
        }
    }


}