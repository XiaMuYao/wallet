package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityMessagelistinfoBinding
import com.xiamuyao.ulanbator.viewmodel.MessageListInfoViewModel


/**
 * 资讯消息详情
 */
class MessageListInfoActivity : BaseActivity<ActivityMessagelistinfoBinding, MessageListInfoViewModel>() {

    override fun initView() {
        viewModel.messageId.value = intent.getStringExtra("messageId")!!
    }

    override fun initVVMObserver() {
        viewModel.messageId.observe(this, Observer {
            viewModel.getPageData()
        })
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_messagelistinfo
    }

    override fun initVariableId(): Int {
        return BR.messagelistinfoViewModel
    }

    override fun initViewModel(): Class<MessageListInfoViewModel> {
        return MessageListInfoViewModel::class.java
    }


    companion object {
        fun start(context: Context, messageId: String) {
            val starter = Intent(context, MessageListInfoActivity::class.java)
            starter.putExtra("messageId", messageId)
            context.startActivity(starter)
        }
    }
}