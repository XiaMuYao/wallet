package com.xiamuyao.ulanbator

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableArrayList
import com.google.gson.Gson
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.xiamuyao.ulanbator.constant.ProjectConstant
import com.xiamuyao.ulanbator.model.bean.MarketBean
import com.xiamuyao.ulanbator.model.repository.PlaceRepository
import com.xiamuyao.ulanbator.model.repository.UserRepository
import com.xiamuyao.ulanbator.network.ServiceCreator
import com.xiamuyao.ulanbator.network.api.BusinessService
import com.xiamuyao.ulanbator.network.api.UserService
import com.xiamuyao.ulanbator.utlis.LL
import com.zhangke.websocket.SimpleListener
import com.zhangke.websocket.WebSocketHandler
import com.zhangke.websocket.WebSocketSetting
import com.zhangke.websocket.response.ErrorResponse
import com.zhangke.websocket.util.GzipUtil
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import java.nio.ByteBuffer
import kotlin.properties.Delegates


class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        //创建
        bind<BusinessService>() with singleton { ServiceCreator.create(BusinessService::class.java) }
        bind<UserService>() with singleton { ServiceCreator.create(UserService::class.java) }

        //从容器中选择
        bind<PlaceRepository>() with singleton { PlaceRepository.getInstance(instance()) }
        bind<UserRepository>() with singleton { UserRepository.getInstance(instance()) }

    }

    init {

        val btcusdt = MarketBean.TickBean()
        btcusdt.cch = "market.btcusdt.detail"
        btcusdt.pairName = "BTC"

        val ethusdt = MarketBean.TickBean()
        ethusdt.cch = "market.ethusdt.detail"
        ethusdt.pairName = "ETH"

        val ltcusdt = MarketBean.TickBean()
        ltcusdt.cch = "market.ltcusdt.detail"
        ltcusdt.pairName = "LTC"

        val eosusdt = MarketBean.TickBean()
        eosusdt.cch = "market.eosusdt.detail"
        eosusdt.pairName = "EOS"

        val etcusdt = MarketBean.TickBean()
        etcusdt.cch = "market.etcusdt.detail"
        etcusdt.pairName = "ETC"

        marketList.add(btcusdt)
        marketList.add(ethusdt)
        marketList.add(ltcusdt)
        marketList.add(eosusdt)
        marketList.add(etcusdt)
    }
    companion object {
        var CONTEXT: Context by Delegates.notNull()
        var marketList = ObservableArrayList<MarketBean.TickBean>()

    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext

        LibApp.init(CONTEXT)

        initWebSocket()

        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white)//全局设置主题颜色
            ClassicsHeader(context)//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        }
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
            //指定为经典Footer，默认是 BallPulseFooter
            ClassicsFooter(context).setDrawableSize(20f)
        }

    }

    private fun initWebSocket() {
        val setting = WebSocketSetting()
        setting.connectUrl = "wss://api.huobipro.com/ws"

        //设置连接超时时间
        setting.connectTimeout = 15 * 1000

        //设置心跳间隔时间
        setting.connectionLostTimeout = 20

        //设置断开后的重连次数，可以设置的很大，不会有什么性能上的影响
        setting.reconnectFrequency = 60

        //网络状态发生变化后是否重连，
        //需要调用 WebSocketHandler.registerNetworkChangedReceiver(context) 方法注册网络监听广播
        setting.setReconnectWithNetworkChanged(true)

        //通过 init 方法初始化默认的 WebSocketManager 对象
        val manager = WebSocketHandler.init(setting)
        //启动连接
        manager.start()

        //注意，需要在 AndroidManifest 中配置网络状态获取权限
        //注册网路连接状态变化广播
        WebSocketHandler.registerNetworkChangedReceiver(this)

        WebSocketHandler.getDefault().addListener(socketListener)

    }
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
//                    //寻找数据插入还是修改
                    for ((index, indexData) in marketList.withIndex()) {
                        if (indexData.cch == fromJson.getCh()) {
                            fromJson.getTick()?.cch = indexData.cch
                            fromJson.getTick()?.pairName = indexData.pairName
                            marketList[index] = fromJson.getTick()
                            //已经得到最后数 计算
                            val tickBean = marketList[index]
                            val subtract = tickBean.close.toBigDecimal().subtract(tickBean.open.toBigDecimal())
                            val multiply = subtract.div(tickBean.open.toBigDecimal()).multiply(100.toBigDecimal())
                            marketList[index].upAndDown = "${multiply.toString()}"
                            break
                        }
                    }

                }
            }

        }
    }



}