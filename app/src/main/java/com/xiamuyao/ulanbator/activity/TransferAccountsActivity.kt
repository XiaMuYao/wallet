package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.ActivityTransferaccountsBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.viewmodel.TransferAccountsViewModel
import kotlinx.android.synthetic.main.layout_titlebar.*

/**
 * 转账界面
 */
class TransferAccountsActivity : BaseActivity<ActivityTransferaccountsBinding, TransferAccountsViewModel>() {

    override fun initView() {

        viewModel.pairType.value = intent.getStringExtra("pairType")
        viewModel.pairName.value = intent.getStringExtra("pairName")
        viewModel.type.value = intent.getBooleanExtra("type",false)

        viewModel.msymbolFeeRate.value = intent.getStringExtra("msymbolFeeRate")
        viewModel.mbalance.value = intent.getStringExtra("balance")


        setTitleBar(
            "${viewModel.pairName.value}" + getString(R.string.gotoAddress),
            { finish() },
            titleBarColor = R.color.touming,
            rightCallBack = { ScanActivity.start(this) },
            rightImageView = R.id.titleBarRightImage
        )

        binding.userImput.addTextChangedListener {

            viewModel.calculationFee()
        }
    }

    override fun initVVMObserver() {

        DataBus.observeData(this, "CodeResult", object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.address.value = it
            }
        })
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_transferaccounts
    }

    override fun initVariableId(): Int {
        return BR.transferaccountsViewModel
    }

    override fun initViewModel(): Class<TransferAccountsViewModel> {
        return TransferAccountsViewModel::class.java
    }

}