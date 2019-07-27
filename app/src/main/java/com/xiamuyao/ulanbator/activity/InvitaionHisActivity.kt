package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.adapter.BaseObservableNoChildClickAdapter
import com.xiamuyao.ulanbator.databinding.ActivityInvitaionhisBinding
import com.xiamuyao.ulanbator.extension.defaultStyle
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.InvitaionHisViewModel


/**
 * 邀请记录
 */
class InvitaionHisActivity : BaseActivity<ActivityInvitaionhisBinding, InvitaionHisViewModel>() {

    private val invitaionHisAdapter by lazy {
        BaseObservableNoChildClickAdapter(R.layout.item_invitaion, viewModel.invitaionHis, BR.invataionListBean)
    }

    override fun initView() {
        setTitleBar("邀请记录", { finish() })

        binding.invitaionhisRecyclerView.defaultStyle(invitaionHisAdapter)

    }

    override fun initVVMObserver() {
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_invitaionhis
    }

    override fun initVariableId(): Int {
        return BR.invitaionhisViewModel
    }

    override fun initViewModel(): Class<InvitaionHisViewModel> {
        return InvitaionHisViewModel::class.java
    }

    companion object {
        fun start(context: Context, message: String? = "") {
            val starter = Intent(context, InvitaionHisActivity::class.java)
            starter.putExtra("message", message)
            context.startActivity(starter)
        }
    }
}