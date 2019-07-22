package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.databinding.FragmentFollowBinding
import com.xiamuyao.ulanbator.databinding.FragmentRecommendCommunityBinding
import com.xiamuyao.ulanbator.viewmodel.FollowCommunityViewModel
import com.xiamuyao.ulanbator.viewmodel.RecommendCommunityViewModel


/**
 * 关注社区
 */
class FollowCommunityFragment : BaseFragment<FragmentFollowBinding, FollowCommunityViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): FollowCommunityFragment {
            val messageFragment = FollowCommunityFragment()
            messageFragment.arguments = bundle
            return messageFragment
        }
    }

    override fun initView() {
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): Int {
        return R.layout.fragment_follow_community
    }

    override fun initVariableId(): Int {
        return BR.recommendFollowViewModel
    }

    override fun initViewModel(): Class<FollowCommunityViewModel> {
        return FollowCommunityViewModel::class.java
    }

}