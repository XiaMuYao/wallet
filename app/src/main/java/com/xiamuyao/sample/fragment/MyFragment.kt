package com.xiamuyao.sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.xiamuyao.sample.BR
import com.xiamuyao.sample.R
import com.xiamuyao.sample.databinding.FragmentMyBinding
import com.xiamuyao.sample.viewmodel.MyViewModel
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.adapter.BaseNoChildClickAdapter
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.utlis.LL


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
        binding.ButtonwrapContent.setOnClickListener {

        }
    }

    override fun initVVMObserver() {
        viewModel.mylist.observe(this, Observer {
            myAdapter.setNewData(it)
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