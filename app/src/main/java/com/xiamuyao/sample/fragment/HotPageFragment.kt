package com.xiamuyao.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.xiamuyao.sample.R
import com.xiamuyao.sample.viewmodel.HotViewModel
import com.xiamuyao.ulanbator.base.BaseFragment

class HotPageFragment : BaseFragment<com.xiamuyao.sample.databinding.FragmentHotBinding, HotViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): HotPageFragment {
            val hotPageFragment = HotPageFragment()
            hotPageFragment.arguments = bundle
            return hotPageFragment
        }
    }

    override fun initVVMObserver() {
        viewModel.textStr.value = arguments?.getString("title")
    }

    override fun initView() {
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_hot_page
    }

    override fun initVariableId(): Int {
        return BR.hotViewModel
    }

    override fun initViewModel(): Class<HotViewModel> {
        return HotViewModel::class.java
    }

}
