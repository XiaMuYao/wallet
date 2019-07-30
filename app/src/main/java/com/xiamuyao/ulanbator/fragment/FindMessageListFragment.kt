package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.MessageListInfoActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.FragmentFindmessagelistBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.FindMessageListViewModel


class FindMessageListFragment : BaseFragment<FragmentFindmessagelistBinding, FindMessageListViewModel>() {
    private val findMessageADapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_find_message, viewModel.findMessage, BR.findMessageBean)
    }

    override fun initView() {
        viewModel.requesttype.value = arguments?.getString("title")!!
        binding.messageRecyclerView.defaultStyle(findMessageADapter)
        findMessageADapter.setOnItemClickListener { _, _, position ->
            MessageListInfoActivity.start(context!!, viewModel.findMessage[position].url.toString())
        }
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_findmessagelist
    }

    override fun initVariableId(): Int {
        return BR.findmessagelistViewModel
    }

    override fun initViewModel(): Class<FindMessageListViewModel> {
        return FindMessageListViewModel::class.java
    }

    companion object {
        fun newInstance(bundle: Bundle?): FindMessageListFragment {
            val findMessageListFragment = FindMessageListFragment()
            findMessageListFragment.arguments = bundle
            return findMessageListFragment
        }
    }

}