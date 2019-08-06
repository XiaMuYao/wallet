package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityTestBinding
import com.xiamuyao.ulanbator.viewmodel.TestViewModel


class TestActivity : BaseActivity<ActivityTestBinding, TestViewModel>() {

    override fun initView() {
        binding.signSeekBar.setValueFormatListener { progress -> "$$progress" }
        binding.signSeekBar.configBuilder.signColor(Color.parseColor("#00FFFFFF")).build()





    }
    companion object {
        fun start(context: Context, message: String?) {
            val starter = Intent(context, TestActivity::class.java)
            starter.putExtra("message",message)
            context.startActivity(starter)
        }
    }

    override fun initVVMObserver() {
    }



    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_test
    }

    override fun initVariableId(): Int {
        return BR.testViewModel
    }

    override fun initViewModel(): Class<TestViewModel> {
        return TestViewModel::class.java
    }

}