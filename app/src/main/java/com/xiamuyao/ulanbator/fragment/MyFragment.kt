package com.xiamuyao.ulanbator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.activity.*
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.databinding.FragmentMyBinding
import com.xiamuyao.ulanbator.viewmodel.MyViewModel


class MyFragment : BaseFragment<FragmentMyBinding, MyViewModel>() {
    companion object {
        fun newInstance(bundle: Bundle?): MyFragment {
            val myFragment = MyFragment()
            myFragment.arguments = bundle
            return myFragment
        }
    }


    override fun initView() {
        //个人信息
        binding.imageView7.setOnClickListener {
            UserInfoActivity.start(context!!)
        }
        //VIP
        binding.constraintLayout3.setOnClickListener {
            //        AboutActivity.start(context)
        }
        //邀请返佣
        binding.constraintLayout4.setOnClickListener {
            InvitationAndReturnMoneyActivity.start(context!!)
        }
        //安全中心
        binding.constraintLayout5.setOnClickListener {
            SaveCenterActivity.start(context!!)
        }
        //系统设置
        binding.constraintLayout6.setOnClickListener {
            SystemSettingActivity.start(context!!)
        }
        binding.constraintLayout7.setOnClickListener {
            //        AboutActivity.start(context)
        }

        binding.constraintLayout8.setOnClickListener {
            HelpActivity.start(context!!)
        }
        binding.constraintLayout9.setOnClickListener {
            AboutActivity.start(context!!)
        }
    }


    override fun initVVMObserver() {


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