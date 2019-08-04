package com.xiamuyao.ulanbator.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivitySendinfoBinding
import com.xiamuyao.ulanbator.util.CountTime
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.SendInfoViewModel

/**
 * 发送详情
 */
class SendInfoActivity : BaseActivity<ActivitySendinfoBinding, SendInfoViewModel>() {

    override fun initView() {

        viewModel.pairName.value = intent.getStringExtra("pairName")
        viewModel.pairType.value = intent.getStringExtra("pairType")
        viewModel.type.value = intent.getBooleanExtra("type",false)


        viewModel.money.value = intent.getStringExtra("money")
        viewModel.address.value = intent.getStringExtra("address")
        viewModel.memoAddress.value = intent.getStringExtra("memoAddress")
        viewModel.userSymbolFeeRate.value = intent.getStringExtra("userSymbolFeeRate")

        setTitleBar(
            leftCallBack = { finish() },
            title = "发送详情"
        )
    }

    override fun initVVMObserver() {

        //倒计时
        val countTime = CountTime(textView = binding.phoneCode)

        viewModel.sendCodeType.observe(this, Observer {

            if (!countTime.start) {
                countTime.start()
            }

        })

    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_sendinfo
    }

    override fun initVariableId(): Int {
        return BR.sendinfoViewModel
    }

    override fun initViewModel(): Class<SendInfoViewModel> {
        return SendInfoViewModel::class.java
    }

}