package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.databinding.FragmentRecommendCommunityBinding
import com.xiamuyao.ulanbator.viewmodel.RecommendCommunityViewModel


/**
 * 推荐社区
 */
class RecommendCommunityFragment : BaseFragment<FragmentRecommendCommunityBinding, RecommendCommunityViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): RecommendCommunityFragment {
            val messageFragment = RecommendCommunityFragment()
            messageFragment.arguments = bundle
            return messageFragment
        }
    }

    override fun initView() {

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_recommend_community
    }

    override fun initVariableId(): Int {
        return BR.recommendCommunityViewModel
    }

    override fun initViewModel(): Class<RecommendCommunityViewModel> {
        return RecommendCommunityViewModel::class.java
    }

}