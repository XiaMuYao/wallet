package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.WalletInfoActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.FragmentHomeBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.viewmodel.WalletViewModel


class WalletFragment : BaseFragment<FragmentHomeBinding, WalletViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): WalletFragment {
            val homeFragment = WalletFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    private val wallerAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_wallet, viewModel.walletList, BR.walletListBean)
    }

    override fun initView() {
        binding.walletRecyclerView.defaultStyle(wallerAdapter)
        binding.walletShow.setOnClickListener {
            viewModel.showOrHide.value = viewModel.showOrHide.value!!.not()
            viewModel.showOrHideListData()
        }
        wallerAdapter.setOnItemClickListener { _, _, position ->

            WalletInfoActivity.start(context!!)
        }

    }

    override fun initVVMObserver() {

        DataBus.observeData(this, EventConstant.BTC_Refresh, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {

            }
        })

    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_home
    }

    override fun initVariableId(): Int {
        return BR.walletViewModel
    }

    override fun initViewModel(): Class<WalletViewModel> {
        return WalletViewModel::class.java
    }


}