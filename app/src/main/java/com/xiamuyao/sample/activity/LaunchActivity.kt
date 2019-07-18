package com.xiamuyao.sample.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.R
import com.xiamuyao.sample.databinding.ActivityLaunchBinding
import com.xiamuyao.sample.viewmodel.LaunchViewModel
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.utlis.LL
import kotlinx.coroutines.launch

class LaunchActivity : BaseActivity<ActivityLaunchBinding, LaunchViewModel>() {

    override fun initView() {

        lifecycleScope.launch {
            MainActivity.start(this@LaunchActivity)
            finish()
        }

    }

    override fun initVVMObserver() {
//        viewModel.mylistmylist.observe(this, Observer {
//            LL.d("数据更改过")
//        })
//        viewModel.mylistmylist?.observe(this, Observer {
//            LL.d("数据更改过")
//        })
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_launch
    }

    override fun initVariableId(): Int {
        return BR.launchViewModel
    }

    override fun initViewModel(): Class<LaunchViewModel> {
        return LaunchViewModel::class.java
    }

}