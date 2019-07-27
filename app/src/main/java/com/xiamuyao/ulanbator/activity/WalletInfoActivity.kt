package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.ActivityWalletinfoBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.WalletInfoViewModel

/**
 * 钱包交易记录
 */
class WalletInfoActivity : BaseActivity<ActivityWalletinfoBinding, WalletInfoViewModel>() {

    private val walletListAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_wallet_info, viewModel.walletInfo, BR.walletListInfoBean)
    }

    override fun initView() {
        binding.walletInfoRecyclerView.defaultStyle(walletListAdapter)
        binding.outMoney.setOnClickListener { }
        binding.inMoney.setOnClickListener { }
    }

    override fun initVVMObserver() {
    }

     override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_walletinfo
    }

    override fun initVariableId(): Int {
        return BR.walletinfoViewModel
    }

    override fun initViewModel(): Class<WalletInfoViewModel> {
        return WalletInfoViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String?=null) {
            val starter = Intent(context, WalletInfoActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}