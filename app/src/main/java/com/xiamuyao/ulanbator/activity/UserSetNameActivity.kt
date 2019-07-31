package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityUsersetnameBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.UserSetNameViewModel


class UserSetNameActivity : BaseActivity<ActivityUsersetnameBinding, UserSetNameViewModel>() {

    override fun initView() {


        setTitleBar("昵称", { finish() })

        viewModel.userName.value = intent.getStringExtra("userName")

        binding.cancel.setOnClickListener { finish() }
        binding.button3.setOnClickListener { viewModel.saveUserName() }
        binding.imageView9123.setOnClickListener { viewModel.cleanName() }

    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_usersetname
    }

    override fun initVariableId(): Int {
        return BR.usersetnameViewModel
    }

    override fun initViewModel(): Class<UserSetNameViewModel> {
        return UserSetNameViewModel::class.java
    }

    companion object {
        fun start(context: Context, userName: String? = "") {
            val starter = Intent(context, UserSetNameActivity::class.java)
            starter.putExtra("userName", userName)
            context.startActivity(starter)
        }
    }


}