package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityFirstsetmonpsdBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.ActivityStackManager
import com.xiamuyao.ulanbator.viewmodel.FirstSetMonPsdViewModel


/**
 * 初次设置资金密码
 */
class FirstSetMonPsdActivity : BaseActivity<ActivityFirstsetmonpsdBinding, FirstSetMonPsdViewModel>() {


    override fun initView() {
        setTitleBar(titleBarColor = R.color.touming, leftCallBack = { finish() })
    }

    override fun initVVMObserver() {

    }

    override fun onBackPressed() {
        super.onBackPressed()

        viewModel.startActivity(MainActivity::class.java)
        ActivityStackManager.getInstance().finishAllActivity()

    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_firstsetmonpsd
    }

    override fun initVariableId(): Int {
        return BR.firstsetmonpsdViewModel
    }

    override fun initViewModel(): Class<FirstSetMonPsdViewModel> {
        return FirstSetMonPsdViewModel::class.java
    }

}