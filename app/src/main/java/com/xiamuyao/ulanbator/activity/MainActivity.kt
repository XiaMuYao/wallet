package com.xiamuyao.ulanbator.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
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
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.fragment.*
import com.xiamuyao.ulanbator.model.bean.MarketBean
import com.xiamuyao.ulanbator.utlis.LL
import com.zhangke.websocket.SimpleListener
import com.zhangke.websocket.WebSocketHandler
import com.zhangke.websocket.WebSocketSetting
import com.zhangke.websocket.response.ErrorResponse
import com.zhangke.websocket.util.GzipUtil
import java.nio.ByteBuffer

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), ViewPager.OnPageChangeListener,
    View.OnClickListener {
    val setting = WebSocketSetting()

    private val socketListener = object : SimpleListener() {
        override fun onConnected() {
            LL.d("链接成功 发送数据")

            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_BTC)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_ETH)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_LTC)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_EOS)
            WebSocketHandler.getDefault().send(ProjectConstant.SUB_STR_ETC)

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

            if (pong.length < 30) {
                val replace = pong.replace("ping", "pong")
                WebSocketHandler.getDefault().send(replace)
            } else {
                val fromJson = Gson().fromJson(pong, MarketBean::class.java)
                if (null != fromJson.getTick()) {


                    for ((index, indexData) in viewModel.marketList.withIndex()) {
                        if (indexData.cch == fromJson.getCh()) {
                            fromJson.getTick()?.cch = indexData.cch
                            fromJson.getTick()?.pairName = indexData.pairName
                            viewModel.marketList[index] = fromJson.getTick()
                            break
                        }
                    }

                }
            }

        }
    }
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

        initWebSocket()
        startManager()
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


    fun startManager() {
        //通过 init 方法初始化默认的 WebSocketManager 对象
        val manager = WebSocketHandler.init(setting)
        //启动连接
        manager.start()

        //注意，需要在 AndroidManifest 中配置网络状态获取权限
        //注册网路连接状态变化广播
        WebSocketHandler.registerNetworkChangedReceiver(this)
    }


    private fun initWebSocket() {

        //连接地址，必填，例如 wss://echo.websocket.org
        setting.connectUrl = "wss://api.huobipro.com/ws"//必填

        //设置连接超时时间
        setting.connectTimeout = 15 * 1000

        //设置心跳间隔时间
        setting.connectionLostTimeout = 10

        //设置断开后的重连次数，可以设置的很大，不会有什么性能上的影响
        setting.reconnectFrequency = 60

        //网络状态发生变化后是否重连，
        //需要调用 WebSocketHandler.registerNetworkChangedReceiver(context) 方法注册网络监听广播
        setting.setReconnectWithNetworkChanged(true)


    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }
}
