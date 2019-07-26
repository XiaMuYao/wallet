package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySelectlaunageBinding
import com.xiamuyao.ulanbator.viewmodel.SelectLaunageViewModel


class SelectLaunageActivity : BaseActivity<ActivitySelectlaunageBinding, SelectLaunageViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_selectlaunage
    }

    override fun initVariableId(): Int {
        return BR.selectlaunageViewModel
    }

    override fun initViewModel(): Class<SelectLaunageViewModel> {
        return SelectLaunageViewModel::class.java
    }

}