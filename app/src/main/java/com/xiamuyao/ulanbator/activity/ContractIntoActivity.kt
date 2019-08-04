package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
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
import com.xiamuyao.ulanbator.view.CustomPopupWindow
import com.xiamuyao.ulanbator.viewmodel.ContractIntoViewModel
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import kotlinx.android.synthetic.main.item_contract.*


/**
 * 合约 操作
 */
class ContractIntoActivity : BaseActivity<ActivityContractintoBinding, ContractIntoViewModel>() {


    override fun initView() {
        setTitleBar("转入", { finish() }, rightText = getString(R.string.yaoqingguize), titleBarColor = R.color.touming)



        viewModel.productId.value = intent.getStringExtra("productId")
        viewModel.shouyiText.value = intent.getStringExtra("shouyiText")
        viewModel.from.value = intent.getStringExtra("from")
        //设置进度条
        binding.signSeekBar.setValueFormatListener { progress -> "$$progress" }
        binding.signSeekBar.configBuilder.signColor(Color.parseColor("#00FFFFFF")).build()

        binding.editText.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                viewModel.nowSelectPrice.value = "0"
                return@addTextChangedListener
            }
            viewModel.calculateTheAmountAfterTheInput(viewModel.inoutMoney.value?.toBigDecimal()!!)
            setData()
        }

        binding.constraintLayout.setOnClickListener {
            if (viewModel.from.value != "2") {
                val customPopupWindow = CustomPopupWindow(this, viewModel.pariList)
                customPopupWindow.showAsDropDown(binding.constraintLayout)
            }

        }

    }


    override fun initVVMObserver() {
        viewModel.productId.observe(this, Observer {
            viewModel.getPageData(it)
        })

        viewModel.loadOk.observe(this, Observer {

            setData()


            if (viewModel.from.value == "2") {
                binding.button.visibility = View.VISIBLE
            } else {

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
                if (viewModel.inoutMoney.value.isNullOrEmpty()) return
                viewModel.calculateTheAmountAfterTheInput(viewModel.inoutMoney.value?.toBigDecimal()!!)
            }
        })
        DataBus.observeData(this, EventConstant.SELECT_PAIR_PRICE, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectPairPrice.value = it

            }
        })
        DataBus.observeData(this, EventConstant.SELECT_PAIR_INDEX, object : DataBusObservable<Int> {
            override fun dataBusDataCallBack(it: Int) {
                viewModel.setTitle1(it.toInt())

            }
        })
    }

    private fun setData() {
        if (viewModel.from.value == "1") {
            val s = "预计" + viewModel.earningsStartTime.value + "产生收益，" + viewModel.incomeArrivalTime.value + "收益到账"
            binding.textView32.setText(s)

        } else {
            val ss =
                "封闭期" + viewModel.introintro.value + ",预计收益" + viewModel.nowSelectPrice.value + "MAX," + viewModel.dueTransferTime.value + "期满转入" + "S1" + "活期"
            binding.textView32.setText(ss)
        }
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
        fun start(context: Context, productId: String, shouyiText: String, from: String) {
            val starter = Intent(context, ContractIntoActivity::class.java)
            starter.putExtra("productId", productId)
            starter.putExtra("shouyiText", shouyiText)
            starter.putExtra("from", from)
            context.startActivity(starter)
        }
    }


}
