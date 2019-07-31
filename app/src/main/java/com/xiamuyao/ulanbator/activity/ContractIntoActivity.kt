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
import com.xiamuyao.ulanbator.model.bean.response.GetMoneyShopBean
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.view.CustomPopupWindow
import com.xiamuyao.ulanbator.viewmodel.ContractIntoViewModel
import com.zhouyou.view.seekbar.SignSeekBar


/**
 * 合约 操作
 */
class ContractIntoActivity : BaseActivity<ActivityContractintoBinding, ContractIntoViewModel>() {


    override fun initView() {
        setTitleBar("转入", { finish() }, rightText = "邀请规则", titleBarColor = R.color.touming)

        binding.constraintLayout.setOnClickListener {
            val customPopupWindow = CustomPopupWindow(this, viewModel.pariList)
            customPopupWindow.showAsDropDown(binding.constraintLayout)
        }

        //获取数据
        val extras = intent.extras?.getBundle("DataPojo")
        viewModel.tempBean.value = extras?.getSerializable("data") as GetMoneyShopBean.DataBean.ListBean
        //from
        viewModel.from = extras.getString("from", "1")
        //设置页面状态
        viewModel.type.value = viewModel.tempBean.value!!.stateType
        setPageData()

        //设置进度条
        binding.signSeekBar.setValueFormatListener { progress -> "$$progress" }
        binding.signSeekBar.configBuilder.signColor(Color.parseColor("#00FFFFFF")).build()

    }

    private fun setPageData() {
        //页面标题 买入 S1合约 日化 0.1%～0.2%
        var title = viewModel.tempBean.value?.title
        var str = viewModel.tempBean.value?.shouyiText
        //解约天数限制
        var substr = viewModel.tempBean.value?.leaveDay
        var dd = viewModel.tempBean.value?.interestMin

        var lastStr = ""
        if (viewModel.from == "1") {
            lastStr = "买入 " + title + "合约 " + "日化 " + str
        } else if (viewModel.from == "2") {
            lastStr = "买入 " + title + "定期" + substr + "月化 " + dd
        }
        viewModel.shopTitle.value = lastStr
    }

    override fun initVVMObserver() {
        viewModel.type.observe(this, Observer {
            when (it) {
                2 -> {
                    binding.button.visibility = View.VISIBLE
                }
                0 -> {
                    binding.button3.visibility = View.VISIBLE
                    binding.button5.visibility = View.VISIBLE
                }
                1 -> {
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
        fun start(context: Context, bundle: Bundle) {
            val starter = Intent(context, ContractIntoActivity::class.java)
            starter.putExtra("DataPojo", bundle)
            context.startActivity(starter)
        }
    }


}
