package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.databinding.ActivityUserinfoBinding
import com.xiamuyao.ulanbator.util.UsetUtli
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.viewmodel.UserInfoViewModel


class UserInfoActivity : BaseActivity<ActivityUserinfoBinding, UserInfoViewModel>() {

    override fun initView() {
        setTitleBar("个人信息", { finish() })

        //昵称
        binding.constraintLayout1.setOnClickListener {
            UserSetNameActivity.start(this, viewModel.nickName.value)
        }
    }

    override fun initVVMObserver() {
        DataBus.observeData(this, EventConstant.SetName, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
               viewModel. nickName.value = UsetUtli.getUserName()
            }
        })
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_userinfo
    }

    override fun initVariableId(): Int {
        return BR.userinfoViewModel
    }

    override fun initViewModel(): Class<UserInfoViewModel> {
        return UserInfoViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, UserInfoActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}