package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.ActivityReturnmoneyhisBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.ReturnMoneyHisViewModel


/**
 * 返佣记录
 */
class ReturnMoneyHisActivity : BaseActivity<ActivityReturnmoneyhisBinding, ReturnMoneyHisViewModel>() {

    private val returnMoneyHisAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_return_money, viewModel.returnMoneyHis, BR.returnMoneyHisBean)
    }

    override fun initView() {
        setTitleBar(getString(R.string.fanyongji), { finish() })
        binding.returnMoneyRecyclerView.defaultStyle(returnMoneyHisAdapter)

        //返佣详情
        returnMoneyHisAdapter.setOnItemClickListener { _, _, position ->
            ReturnMoneyInfoActivity.start(this,returnMoneyHisAdapter.getItem(position)?.id)
        }
    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_returnmoneyhis
    }

    override fun initVariableId(): Int {
        return BR.returnmoneyhisViewModel
    }

    override fun initViewModel(): Class<ReturnMoneyHisViewModel> {
        return ReturnMoneyHisViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, ReturnMoneyHisActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }

}