package com.xiamuyao.sample.activity

import android.content.ContentValues
import android.os.Bundle
import android.view.View
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.R
import com.xiamuyao.sample.databinding.ActivityLaunchBinding
import com.xiamuyao.sample.fragment.FindFragment
import com.xiamuyao.sample.fragment.FragmentA
import com.xiamuyao.sample.fragment.HomeFragment
import com.xiamuyao.sample.fragment.MyFragment
import com.xiamuyao.sample.viewmodel.LaunchViewModel
import com.xiamuyao.ulanbator.base.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LaunchActivity : BaseActivity<ActivityLaunchBinding, LaunchViewModel>() {

    override fun initView() {

//        lifecycleScope.launch {
//            delay(500)
            MainActivity.start(this@LaunchActivity)
//            finish()
//        }

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