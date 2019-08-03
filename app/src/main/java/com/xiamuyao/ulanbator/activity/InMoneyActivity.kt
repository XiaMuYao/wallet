package com.xiamuyao.ulanbator.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.xiamuyao.ulanbator.App
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityInmoneyBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.utlis.To
import com.xiamuyao.ulanbator.viewmodel.InMoneyViewModel


/**
 * 钱包收款
 */
class InMoneyActivity : BaseActivity<ActivityInmoneyBinding, InMoneyViewModel>() {

    override fun initView() {
        viewModel.pairType.value = intent.getStringExtra("pairType")
        viewModel.pairName.value = intent.getStringExtra("pairName")

        setTitleBar(title = viewModel.pairName.value!!+getString(R.string.inmoney), titleBarColor = R.color.touming, leftCallBack = { finish() })

    }

    override fun initVVMObserver() {
        viewModel.pairType.observe(this, Observer {
            viewModel.getPageData()
        })

        viewModel.loadOk.observe(this, Observer {
            binding.imageView30.setImageBitmap(viewModel.addressBitMap)

        })
        viewModel.copy.observe(this, Observer {

            val mClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val mClipData = ClipData.newPlainText("Label", viewModel.pairAddress.value!!)
            mClipboardManager.setPrimaryClip(mClipData);
            To.showToast(getString(R.string.copy))

        })

    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_inmoney
    }

    override fun initVariableId(): Int {
        return BR.inmoneyViewModel
    }

    override fun initViewModel(): Class<InMoneyViewModel> {
        return InMoneyViewModel::class.java
    }


}