package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import com.xiamuyao.ulanbator.BR
import com.xiamuyao.ulanbator.R
import com.xiamuyao.ulanbator.adapter.fragmentAdapter.SectionsPagerAdapter
import com.xiamuyao.ulanbator.databinding.ActivityMainBinding
import com.xiamuyao.ulanbator.viewmodel.MainViewModel
import com.xiamuyao.ulanbator.base.BaseActivity
import com.xiamuyao.ulanbator.base.BaseFragment
import com.xiamuyao.ulanbator.base.BaseViewModel
import com.xiamuyao.ulanbator.constant.EventConstant
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.fragment.*
import com.xiamuyao.ulanbator.model.bean.MarketBean
import com.xiamuyao.ulanbator.utlis.DataBus
import com.xiamuyao.ulanbator.utlis.DataBusObservable
import com.xiamuyao.ulanbator.utlis.LL
import com.zhangke.websocket.SimpleListener
import com.zhangke.websocket.WebSocketHandler
import com.zhangke.websocket.WebSocketSetting
import com.zhangke.websocket.response.ErrorResponse
import com.zhangke.websocket.util.GzipUtil
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.nio.ByteBuffer

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), ViewPager.OnPageChangeListener,
    View.OnClickListener {

    private val mFragmentList: Array<BaseFragment<out ViewDataBinding, out BaseViewModel>> by lazy {
        arrayOf(
            WalletFragment.newInstance(null),
            QuotationFragment.newInstance(null),
            ManagingMoneyFragment.newInstance(null),
            FindFragment.newInstance(null),
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
        binding.include2.mainBottomTabFive.setOnClickListener(this)
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
        //行情 - 改变汇率
        DataBus.observeData(this, EventConstant.quote_Refresh, object : DataBusObservable<String> {
            override fun dataBusDataCallBack(it: String) {
                viewModel.getExchangeRateData()
            }
        })

    }

    override fun initData() {
        with(binding.viewPager) {
            adapter = markerAdapter
            currentItem = viewModel.fragmentIndex.value!!
            addOnPageChangeListener(this@MainActivity)
        }
        //获取汇率数据
        viewModel.getExchangeRateData()

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
