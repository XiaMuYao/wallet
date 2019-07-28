package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityLaunchBinding
import com.xiamuyao.ulanbator.viewmodel.LaunchViewModel
import kotlinx.coroutines.launch

class LaunchActivity : BaseActivity<ActivityLaunchBinding, LaunchViewModel>() {

    override fun initView() {

        lifecycleScope.launch {

            kotlinx.coroutines.delay(2000)
            MainActivity.start(this@LaunchActivity)
            finish()
        }

    }

    override fun initVVMObserver() {

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