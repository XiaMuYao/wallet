package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.databinding.FragmentMessageBinding
import com.xiamuyao.ulanbator.viewmodel.QuotationViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.MainViewModel


class QuotationFragment : BaseFragment<FragmentMessageBinding, QuotationViewModel>() {

    companion object {
        fun newInstance(bundle: Bundle?): QuotationFragment {
            val messageFragment = QuotationFragment()
            messageFragment.arguments = bundle
            return messageFragment
        }
    }

    private val marketAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_market, App.marketList, BR.marketBean)
    }

    override fun initView() {
        binding.marketRecyclerView.defaultStyle(marketAdapter)
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_message
    }

    override fun initVariableId(): Int {
        return BR.quotationViewModel
    }

    override fun initViewModel(): Class<QuotationViewModel> {
        return QuotationViewModel::class.java
    }

}