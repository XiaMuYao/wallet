package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityContractintoBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.view.CustomPopupWindow
import com.xiamuyao.ulanbator.viewmodel.ContractIntoViewModel
import com.zhouyou.view.seekbar.SignSeekBar


/**
 * 合约 操作
 */
class ContractIntoActivity : BaseActivity<ActivityContractintoBinding, ContractIntoViewModel>() {


    override fun initView() {
        setTitleBar("转入", { finish() }, rightText = "邀请规则",titleBarColor = R.color.touming)

        binding.constraintLayout.setOnClickListener {
            val customPopupWindow = CustomPopupWindow(this, viewModel.pariList)
            customPopupWindow.showAsDropDown(binding.constraintLayout)
        }

        viewModel.type.value = intent.getIntExtra("type", -1)

        binding.signSeekBar.setValueFormatListener { progress -> "$$progress" }
        binding.signSeekBar.configBuilder.signColor(Color.parseColor("#00FFFFFF"))
            .build()

    }

    override fun initVVMObserver() {
        viewModel.type.observe(this, Observer {
            when (it) {
                1 -> {
                    binding.button.visibility = View.VISIBLE

                }
                2 -> {
                    binding.button3.visibility = View.VISIBLE
                    binding.button5.visibility = View.VISIBLE
                }
                3 -> {
                    binding.button4.visibility = View.VISIBLE
                }
            }
        })
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
        fun start(context: Context, message: Int) {
            val starter = Intent(context, ContractIntoActivity::class.java)
            starter.putExtra("type", message)
            context.startActivity(starter)
        }
    }


}
