package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySelectlaunageBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SelectLaunageViewModel


/**
 * 选择语言
 */
class SelectLaunageActivity : BaseActivity<ActivitySelectlaunageBinding, SelectLaunageViewModel>() {

    override fun initView() {
        setTitleBar("选择语言", { finish() })

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
    companion object {
        fun start(context: Context, message: String?="") {
            val starter = Intent(context, SelectLaunageActivity::class.java)
            starter.putExtra("message",message)
            context.startActivity(starter)
        }
    }

}