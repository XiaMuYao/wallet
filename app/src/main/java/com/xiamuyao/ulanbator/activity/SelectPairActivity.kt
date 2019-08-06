package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySelectpairBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SelectPairViewModel


/**
 * 选择计价火币
 */
class SelectPairActivity : BaseActivity<ActivitySelectpairBinding, SelectPairViewModel>() {

    override fun initView() {
        setTitleBar(getString(R.string.jijiahuobi), { finish() })

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

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, SelectPairActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}