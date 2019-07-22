package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.databinding.FragmentMessageBinding
import com.xiamuyao.ulanbator.viewmodel.MessageViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.MainViewModel


class MessageFragment : BaseFragment<FragmentMessageBinding, MessageViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): MessageFragment {
            val messageFragment = MessageFragment()
            messageFragment.arguments = bundle
            return messageFragment
        }
    }
    private val mainViewModel by lazy {
        ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
    }

    private val marketAdapter by lazy {
        BaseNoChildClickAdapter(R.layout.item_market,mainViewModel.marketList,BR.marketBean)
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
        return BR.messageViewModel
    }

    override fun initViewModel(): Class<MessageViewModel> {
        return MessageViewModel::class.java
    }

}