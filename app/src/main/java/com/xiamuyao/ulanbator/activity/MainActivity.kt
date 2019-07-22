package com.xiamuyao.ulanbator.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.ObservableArrayList
import androidx.databinding.ViewDataBinding
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.SectionsPagerAdapter
import com.xiamuyao.ulanbator.databinding.ActivityMainBinding
import com.xiamuyao.ulanbator.fragment.FindFragment
import com.xiamuyao.ulanbator.fragment.HomeFragment
import com.xiamuyao.ulanbator.fragment.MessageFragment
import com.xiamuyao.ulanbator.fragment.MyFragment
import com.xiamuyao.ulanbator.viewmodel.MainViewModel
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.model.bean.MarketBean
import com.xiamuyao.ulanbator.utlis.JSONUtils
import com.xiamuyao.ulanbator.utlis.LL
import com.zhangke.websocket.SimpleListener
import com.zhangke.websocket.WebSocketHandler
import com.zhangke.websocket.response.ErrorResponse
import com.zhangke.websocket.util.GzipUtil
import java.nio.ByteBuffer
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), ViewPager.OnPageChangeListener,
    View.OnClickListener {
    private val socketListener = object : SimpleListener() {
        override fun onConnected() {
            LL.d("链接成功 发送数据")
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR)

        }

        override fun onConnectFailed(e: Throwable?) {
            if (e != null) {
            } else {
            }
        }

        override fun onDisconnect() {
        }

        override fun onSendDataError(errorResponse: ErrorResponse) {
            errorResponse.release()
        }

        override fun <T> onMessage(message: String, data: T) {
            println("接收到文本消息：$message")
        }

        override fun <T> onMessage(bytes: ByteBuffer, data: T) {

            var pong = ""

            pong = GzipUtil.unCompress(bytes.array())

            LL.d("接收到二进制消息：onMessage:$pong")

            if (pong.length < 30){
                val replace = pong.replace("ping", "pong")
                WebSocketHandler.getDefault().send(replace)
            }else{
                val fromJson = Gson().fromJson(pong, MarketBean::class.java)
                if (null != fromJson.data){
                    viewModel.marketList.addAll(fromJson.data!!)
                }
            }

        }
    }
    private val mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>> by lazy {
        arrayOf(
            HomeFragment.newInstance(null),
            FindFragment.newInstance(null),
            MessageFragment.newInstance(null),
            MyFragment.newInstance(null)
        )
    }

    private val markerAdapter by lazy {
        SectionsPagerAdapter(supportFragmentManager, mFragmentList)
    }

    override fun onClick(v: View) {
        viewModel.setViewPagerIndex(viewModel.bottomClickIdList.indexOf(v.id))
        selectorBottomImage(viewModel.fragmentIndex.value!!)
    }

    private fun selectorBottomImage(value: Int) {
        viewModel.bottomClickImageIdList.withIndex().forEach {
            binding.root.findViewById<ImageView>(it.value).isSelected = it.index == value
        }
    }

    override fun initView() {
        // 这里可以绑定到 viewmodel 中的 setViewPagerIndex 直接绑定 传参进去
        binding.include2.mainBottomTabOne.setOnClickListener(this)
        binding.include2.mainBottomTabTwo.setOnClickListener(this)
        binding.include2.mainBottomTabThere.setOnClickListener(this)
        binding.include2.mainBottomTabFour.setOnClickListener(this)
        selectorBottomImage(viewModel.fragmentIndex.value!!)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        selectorBottomImage(position)
    }

    override fun initVVMObserver() {
        WebSocketHandler.getDefault().addListener(socketListener)

    }

    override fun initData() {
        with(binding.viewPager) {
            adapter = markerAdapter
            currentItem = viewModel.fragmentIndex.value!!
            addOnPageChangeListener(this@MainActivity)
        }
    }


    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.mainViewModel
    }

    override fun initViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }
}
