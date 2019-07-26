package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityReturnmoneyhisBinding
import com.xiamuyao.ulanbator.viewmodel.ReturnMoneyHisViewModel


class ReturnMoneyHisActivity : BaseActivity<ActivityReturnmoneyhisBinding, ReturnMoneyHisViewModel>() {

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_returnmoneyhis
    }

    override fun initVariableId(): Int {
        return BR.returnmoneyhisViewModel
    }

    override fun initViewModel(): Class<ReturnMoneyHisViewModel> {
        return ReturnMoneyHisViewModel::class.java
    }

}