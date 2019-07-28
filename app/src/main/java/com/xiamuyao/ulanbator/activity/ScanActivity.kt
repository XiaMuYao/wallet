package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityScanBinding
import com.xiamuyao.ulanbator.viewmodel.ScanViewModel

/**
 * 二维码扫描
 */
class ScanActivity : BaseActivity<ActivityScanBinding, ScanViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_scan
    }

    override fun initVariableId(): Int {
        return BR.scanViewModel
    }

    override fun initViewModel(): Class<ScanViewModel> {
        return ScanViewModel::class.java
    }

}