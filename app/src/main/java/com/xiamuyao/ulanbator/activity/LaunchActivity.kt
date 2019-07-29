package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.ProjectConstant.USER_TOKEN
import com.xiamuyao.ulanbator.databinding.ActivityLaunchBinding
import com.xiamuyao.ulanbator.util.getSpValue
import com.xiamuyao.ulanbator.viewmodel.LaunchViewModel
import kotlinx.coroutines.launch

class LaunchActivity : BaseActivity<ActivityLaunchBinding, LaunchViewModel>() {

    override fun initView() {
        //todo 判断app升级

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