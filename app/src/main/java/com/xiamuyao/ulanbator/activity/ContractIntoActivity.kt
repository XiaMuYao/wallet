package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityContractintoBinding
import com.xiamuyao.ulanbator.view.CustomPopupWindow
import com.xiamuyao.ulanbator.viewmodel.ContractIntoViewModel


/**
 * 合约 操作
 */
class ContractIntoActivity : BaseActivity<ActivityContractintoBinding, ContractIntoViewModel>() {


    override fun initView() {

        binding.constraintLayout.setOnClickListener {
            val customPopupWindow = CustomPopupWindow(this, viewModel.pariList)
            customPopupWindow.showAtLocation(binding.constraintLayout, Gravity.CLIP_HORIZONTAL,0,0)
        }
    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_contractinto
    }

    override fun initVariableId(): Int {
        return BR.contractintoViewModel
    }

    override fun initViewModel(): Class<ContractIntoViewModel> {
        return ContractIntoViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = null) {
            val starter = Intent(context, ContractIntoActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }


}
