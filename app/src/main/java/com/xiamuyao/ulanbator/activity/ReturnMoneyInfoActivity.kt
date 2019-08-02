package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.ActivityReturnmoneyinfoBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.ReturnMoneyInfoViewModel


/**
 * 返佣详情
 */
class ReturnMoneyInfoActivity : BaseActivity<ActivityReturnmoneyinfoBinding, ReturnMoneyInfoViewModel>() {

    private val returnMoneyInfoAdapter by lazy {
        BaseObservableNoChildClickAdapter(
            R.layout.item_return_money_info,
            viewModel.returnMoneyInfoHis,
            BR.returnMoneyInfoBean
        )
    }

    override fun initView() {
        setTitleBar("返佣详情", { finish() })

        viewModel.itemId.value = intent.getStringExtra("message")
        binding.returnMoneyInforecyclerView.defaultStyle(returnMoneyInfoAdapter)

    }

    override fun initVVMObserver() {
        viewModel.itemId.observe(this, Observer {
            viewModel.getPageData()
        })
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_returnmoneyinfo
    }

    override fun initVariableId(): Int {
        return BR.returnmoneyinfoViewModel
    }

    override fun initViewModel(): Class<ReturnMoneyInfoViewModel> {
        return ReturnMoneyInfoViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, ReturnMoneyInfoActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}