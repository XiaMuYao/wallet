package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.gyf.immersionbar.ImmersionBar
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityNologinBinding
import com.xiamuyao.ulanbator.viewmodel.NoLoginViewModel


class NoLoginActivity : BaseActivity<ActivityNologinBinding, NoLoginViewModel>() {

    override fun initView() {

        binding.mVideoView.setVideoURI(Uri.parse(viewModel.videoUrl))
        binding.mVideoView.start()

        binding.mVideoView.setOnPreparedListener {
            it.start()
            it.isLooping = true
        }
    }

    override fun setImmersionBar() {
        ImmersionBar.with(this)
            .transparentStatusBar()
            .init()
    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_nologin
    }

    override fun initVariableId(): Int {
        return BR.nologinViewModel
    }

    override fun initViewModel(): Class<NoLoginViewModel> {
        return NoLoginViewModel::class.java
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, NoLoginActivity::class.java)
            // starter.putExtra()
            context.startActivity(starter)
        }
    }
}