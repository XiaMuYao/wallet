package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.ContractIntoActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.FragmentContractfragmentBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.ContractFragmentViewModel

/**
 * 合约
 */
class ContractFragmentFragment : BaseFragment<FragmentContractfragmentBinding, ContractFragmentViewModel>() {

    private val contractAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_contract, viewModel.contractList, BR.contractListBean)
    }

    override fun initView() {
        binding.contractRecyclerView.defaultStyle(contractAdapter)
        contractAdapter.setOnItemClickListener { _, _, position ->
            val item = contractAdapter.getItem(position)
            ContractIntoActivity.start(context!!, item?.productId!!,item.shouyiText!!)
        }
    }

    override fun initVVMObserver() {

    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_contractfragment
    }

    override fun initVariableId(): Int {
        return BR.contractfragmentViewModel
    }

    override fun initViewModel(): Class<ContractFragmentViewModel> {
        return ContractFragmentViewModel::class.java
    }

    companion object {
        fun newInstance(bundle: Bundle?): ContractFragmentFragment {
            val contractFragmentFragment = ContractFragmentFragment()
            contractFragmentFragment.arguments = bundle
            return contractFragmentFragment
        }
    }

}