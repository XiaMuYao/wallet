package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.ContractIntoActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.FragmentFixeddepositfragmentBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.FixedDepositFragmentViewModel


/**
 * 定存
 */
class FixedDepositFragmentFragment :
    BaseFragment<FragmentFixeddepositfragmentBinding, FixedDepositFragmentViewModel>() {

    private val fixedAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_fixed, viewModel.fixedList, BR.fixedListBean)
    }

    override fun initView() {
        binding.fixedRecyclerView.defaultStyle(fixedAdapter)

        fixedAdapter.setOnItemClickListener { _, _, position ->
            val item = fixedAdapter.getItem(position)
            ContractIntoActivity.start(
                context!!,
                item?.productId!!,
                item.interestMax!!,
                "2",
                item.stateRate,
                item.userAmountMaxSum.replace(",","").toInt(),
                item.money,
                item.interestMax
            )
        }

    }

    override fun initVVMObserver() {
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_fixeddepositfragment
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFixedList()
    }
    override fun initVariableId(): Int {
        return BR.fixeddepositfragmentViewModel
    }

    override fun initViewModel(): Class<FixedDepositFragmentViewModel> {
        return FixedDepositFragmentViewModel::class.java
    }

    companion object {
        fun newInstance(bundle: Bundle?): FixedDepositFragmentFragment {
            val fixedDepositFragmentFragment = FixedDepositFragmentFragment()
            fixedDepositFragmentFragment.arguments = bundle
            return fixedDepositFragmentFragment
        }
    }


}