package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.databinding.FragmentMyBinding
import com.xiamuyao.ulanbator.viewmodel.MyViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.extension.defaultRefreshLoadMoreFun


class MyFragment : BaseFragment<FragmentMyBinding, MyViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): MyFragment {
            val myFragment = MyFragment()
            myFragment.arguments = bundle
            return myFragment
        }
    }

    private val myAdapter by lazy {
        BaseNoChildClickAdapter(R.layout.item_my_card_skirt, viewModel.mylist.value, BR.myWanAndroidBean)
    }

    override fun initView() {
        binding.myRecyclerView.defaultStyle(myAdapter)

        binding.swipeRefreshLayout.defaultRefreshLoadMoreFun(LoadMoreBlock = { viewModel.getList(false) }, refreshBlock = { viewModel.getList(true) })
    }


    override fun initVVMObserver() {
        var a = 1

        viewModel.loadMoreStatus.observe(this, Observer {
            a++
            myAdapter.addData(viewModel.mylist.value!!)
            if (a > 3) {
                binding.swipeRefreshLayout.finishLoadMoreWithNoMoreData()
            } else {
                binding.swipeRefreshLayout.finishLoadMore()
            }

        })

        viewModel.refreshStatus.observe(this, Observer {
            myAdapter.setNewData(viewModel.mylist.value)
            binding.swipeRefreshLayout.finishRefresh()
        })

    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_my
    }

    override fun initVariableId(): Int {
        return BR.myViewModel
    }

    override fun initViewModel(): Class<MyViewModel> {
        return MyViewModel::class.java
    }

}