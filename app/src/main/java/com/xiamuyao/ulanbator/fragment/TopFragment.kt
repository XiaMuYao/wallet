package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.HomeItemImageAdapter
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.FragmentTopBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.viewmodel.TopViewModel

class TopFragment : BaseFragment<FragmentTopBinding, TopViewModel>() {

    //顶部消息
    private val topPageTopAapter by lazy {
        BaseNoChildClickAdapter(R.layout.item_top_message, viewModel.topPageTopList, BR.topMessageBean)
    }
    //页面消息
    private val topPageRecyclerView by lazy {
        HomeItemImageAdapter(R.layout.item_home_card_skirt, viewModel.skirtList)
    }

    override fun initVVMObserver() {

    }

    override fun initView() {
        binding.topPageTopRecyclerView.defaultStyle(topPageTopAapter)
        binding.topPageRecyclerView.defaultStyle(topPageRecyclerView)
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_top
    }

    override fun initVariableId(): Int {
        return BR.topViewModel
    }

    override fun initViewModel(): Class<TopViewModel> {
        return TopViewModel::class.java
    }

}
