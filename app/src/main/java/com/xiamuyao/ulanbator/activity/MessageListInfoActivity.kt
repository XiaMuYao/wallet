package com.xiamuyao.ulanbator.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.databinding.ActivityMessagelistinfoBinding
import com.xiamuyao.ulanbator.util.setTitleBar
import com.xiamuyao.ulanbator.viewmodel.MessageListInfoViewModel
import android.os.Build.VERSION_CODES.LOLLIPOP
import android.os.Build.VERSION.SDK_INT
import android.webkit.*


/**
 * 资讯消息详情
 */
class MessageListInfoActivity : BaseActivity<ActivityMessagelistinfoBinding, MessageListInfoViewModel>() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun initView() {


        setTitleBar(
            leftCallBack = { finish() },
            titleBarColor = R.color.touming
        )


        viewModel.messageId.value = intent.getStringExtra("messageId")
        viewModel.id.value = intent.getStringExtra("id")


        //支持javascript
        binding.messaeInfoWebViewmo.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        binding.messaeInfoWebViewmo.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        binding.messaeInfoWebViewmo.getSettings().setBuiltInZoomControls(true);
        //扩大比例的缩放
        binding.messaeInfoWebViewmo.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        binding.messaeInfoWebViewmo.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        binding.messaeInfoWebViewmo.getSettings().setLoadWithOverviewMode(true);



//        //如果不设置WebViewClient，请求会跳转系统浏览器
        binding.messaeInfoWebViewmo.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }

            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                return false
            }

        }
        binding.messaeInfoWebViewmo.loadUrl(viewModel.messageId.value)
        binding.messaeInfoWebViewmo.settings.javaScriptEnabled = true

        binding.messaeInfoWebViewmo.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100) {
                }
            }
        }

    }

    override fun initVVMObserver() {
        binding.messaeInfoWebViewmo.loadUrl(viewModel.messageId.value)
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
        fun start(context: Context, messageId: String, id: String) {
            val starter = Intent(context, MessageListInfoActivity::class.java)
            starter.putExtra("messageId", messageId)
            starter.putExtra("id", id)
            context.startActivity(starter)
        }
    }
}