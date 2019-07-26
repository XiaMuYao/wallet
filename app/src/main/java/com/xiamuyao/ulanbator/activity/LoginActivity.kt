package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityLoginBinding
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.viewmodel.LoginViewModel


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {


    override fun initView() {
        setImageAndClick(R.id.titleBarLeftImage) { finish() }

        binding.btnLogin.setOnClickListener {
            MainActivity.start(this)
        }
        binding.selectCity.setOnClickListener {
            SelectCityActivity.start(this)
        }
    }

    override fun initVVMObserver() {
        DataBus.observeData(this, "selectCityName", object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectCityName.value = it
            }
        })
        DataBus.observeData(this, "selectCityNum", object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.selectCityNum.value = it
            }
        })
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_login
    }

    override fun initVariableId(): Int {
        return BR.loginViewModel
    }

    override fun initViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, LoginActivity::class.java)
            // starter.putExtra()
            context.startActivity(starter)
        }
    }
}