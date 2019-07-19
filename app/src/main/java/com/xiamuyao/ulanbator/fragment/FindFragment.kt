package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.databinding.FragmentFindBinding
import com.xiamuyao.ulanbator.viewmodel.FindViewModel
import com.xiamuyao.ulanbator.base.BaseFragment


class FindFragment : BaseFragment<FragmentFindBinding, FindViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): FindFragment {
            val findFragment = FindFragment()
            findFragment.arguments = bundle
            return findFragment
        }
    }

    override fun initView() {
        binding.ButtonButtonButton.setOnClickListener {

        }
    }

    override fun initVVMObserver() {
    }

    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_find
    }

    override fun initVariableId(): Int {
        return BR.findViewModel
    }

    override fun initViewModel(): Class<FindViewModel> {
        return FindViewModel::class.java
    }

}