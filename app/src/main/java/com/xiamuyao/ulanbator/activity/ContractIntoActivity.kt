package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.ActivityContractintoBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.utlis.LL
import com.xiamuyao.ulanbator.view.CustomPopupWindow
import com.xiamuyao.ulanbator.viewmodel.ContractIntoViewModel


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

        viewModel.productId.value = intent.getStringExtra("productId")
        viewModel.shouyiText.value = intent.getStringExtra("shouyiText")
        //设置进度条
        binding.signSeekBar.setValueFormatListener { progress -> "$$progress" }
        binding.signSeekBar.configBuilder.signColor(Color.parseColor("#00FFFFFF")).build()
        binding.editText.addTextChangedListener {

            LL.d("计算试试汇率钱数")
            viewModel.nowSelectPrice.value = it.toString().toBigDecimal().multiply(2.toBigDecimal()).toString()
        }

    }


    override fun initVVMObserver() {
        viewModel.productId.observe(this, Observer {
            viewModel.getPageData(it)
        })

        viewModel.loadOk.observe(this, Observer {
            //页面属性
            when (viewModel.type.value) {
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


            //进度条
            var min = viewModel.low.value?.toFloat()!!
            var max = viewModel.high.value?.toFloat()!!

            binding.signSeekBar.configBuilder
                .min(min)
                .touchToSeek()
                .max(max)
                .progress(viewModel.usermoney.value?.toFloat()!!)
                .build()
        })

        DataBus.observeData(this, EventConstant.SELECT_PAIRNAME, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectPairName.value = it
            }
        })
        DataBus.observeData(this, EventConstant.SELECT_PAIR_PRICE, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectPairPrice.value = it

            }
        })
        DataBus.observeData(this, EventConstant.SELECT_PAIR_ID, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectPairID.value = it

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
        fun start(context: Context, productId: String, shouyiText: String) {
            val starter = Intent(context, ContractIntoActivity::class.java)
            starter.putExtra("productId", productId)
            starter.putExtra("shouyiText", shouyiText)
            context.startActivity(starter)
        }
    }


}
