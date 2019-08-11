package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.constant.EventConstant.LaunageSet
import com.xiamuyao.ulanbator.databinding.ActivitySelectlaunageBinding
import com.xiamuyao.ulanbator.util.CityUtli
import com.xiamuyao.ulanbator.utlis.LocalManageUtil
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.viewmodel.SelectLaunageViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.exitProcess


/**
 * 选择语言
 */
class SelectLaunageActivity : BaseActivity<ActivitySelectlaunageBinding, SelectLaunageViewModel>() {

    override fun initView() {
        setTitleBar(getString(R.string.xuanzeyyuyan), { finish() })

    }

    override fun initVVMObserver() {
        viewModel.finshThisActivity.observe(this, Observer {

            val find = CityUtli.cityList.find { it.cityId == viewModel.seleValue }
            CityUtli.saveLanguage(find?.cityId!!)
//            LocalManageUtil.saveSelectLanguage(this, find.cityId)

            val intent = Intent(this, LaunchActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            DataBus.postData(LaunageSet,LaunageSet)

            lifecycleScope.launch {
                kotlinx.coroutines.delay(1000)
                startActivity(intent)
                android.os.Process.killProcess(android.os.Process.myPid());
            }

        })
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_selectlaunage
    }

    override fun initVariableId(): Int {
        return BR.selectlaunageViewModel
    }

    override fun initViewModel(): Class<SelectLaunageViewModel> {
        return SelectLaunageViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, SelectLaunageActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}