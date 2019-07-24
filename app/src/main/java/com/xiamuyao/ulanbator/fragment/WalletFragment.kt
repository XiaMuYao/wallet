package com.xiamuyao.ulanbator.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.FragmentHomeBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.view.ScaleTransitionPagerTitleView
import com.xiamuyao.ulanbator.viewmodel.WalletViewModel
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator


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
    }

    override fun initVVMObserver() {

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