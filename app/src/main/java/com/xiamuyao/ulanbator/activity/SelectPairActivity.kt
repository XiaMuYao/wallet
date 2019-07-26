package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySelectpairBinding
import com.xiamuyao.ulanbator.viewmodel.SelectPairViewModel


class SelectPairActivity : BaseActivity<ActivitySelectpairBinding, SelectPairViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_selectpair
    }


    override fun initVariableId(): Int {
        return BR.selectpairViewModel
    }

    override fun initViewModel(): Class<SelectPairViewModel> {
        return SelectPairViewModel::class.java
    }

}